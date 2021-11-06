package org.anz;

import org.anz.compares.Subset;
import org.anz.compares.impl.SubsetBlock;
import org.anz.convertors.Convertor;
import org.anz.convertors.impl.InputConvertor;
import org.anz.convertors.impl.ShapeConvertor;
import org.anz.exception.InvalidInputException;
import org.anz.factory.RotateShapeFactory;
import org.anz.models.Shape;
import org.anz.rotate.RotateShape;
import org.anz.sort.SortShapes;
import org.anz.sort.impl.SortBlocks;
import org.anz.utils.ShapeUtils;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StackHeight {
    private final Convertor<String, String[]> inputConvertor;
    private final SortShapes sortShapes;
    private final Subset subsetShapes;
    private final RotateShapeFactory rotateShapeFactory;

    private StackHeight() {
        inputConvertor = InputConvertor.getInstance();
        sortShapes = SortBlocks
                .getInstance();
        subsetShapes = SubsetBlock.getInstance();
        rotateShapeFactory = RotateShapeFactory.getInstance();
    }

    public static StackHeight getInstance() {
        return StackHeightHelper.INSTANCE;
    }

    public int getMaxStackHeight(String input) {
        try {
            String[] dimensions = inputConvertor.convert(input);
            List<Set<Shape>> rotatedShapesList = getRotateShapes(dimensions);
            final int maxStackHeight;
            //After rearranging the blocks, you can see that all blocks have the same dimension.
            if (ShapeUtils.isRearrangingWithSameDimension(rotatedShapesList)) {
                int maxDimension = Arrays.stream(dimensions[0].split(","))
                        .map(String::trim).mapToInt(Integer::parseInt).max().orElse(0);
                maxStackHeight = maxDimension * dimensions.length;
            } else {
                final List<Shape> rotatedShapes = getSortedRotatedShapes(rotatedShapesList);
                final int[] maxStackHeightsList = computingOptimizedStackHeight(rotatedShapes);
                maxStackHeight = Arrays.stream(maxStackHeightsList).max().orElse(0);
            }
            return maxStackHeight;
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private List<Set<Shape>> getRotateShapes(String[] dimensions) throws InvalidInputException {
        ExecutorService executorService
                = Executors.newFixedThreadPool(4);

        List<Set<Shape>> rotatedShapes = new ArrayList<>();
        List<Future<Set<Shape>>> results = new ArrayList<>();

        for (String dimension : dimensions) {
            Shape shape = ShapeConvertor.getInstance().convert(dimension);
            RotateShape rotateShape = rotateShapeFactory.createRotateShape(shape);
            Future<Set<Shape>> shapeTask = executorService.submit(rotateShape);
            results.add(shapeTask);
        }

        for (Future<Set<Shape>> future : results) {
            try {
                Set<Shape> result = future.get();
                rotatedShapes.add(result);
            } catch (InterruptedException |ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executorService.shutdown();

        return rotatedShapes;
    }


    private List<Shape> getSortedRotatedShapes(List<Set<Shape>> rotatedShapesList) {
        List<Shape> rotatedShapes = new ArrayList<>();
        for (Set<Shape> shapes : rotatedShapesList) {
            rotatedShapes.addAll(shapes);
        }
        sortShapes.sort(rotatedShapes);
        return rotatedShapes;
    }

    private int[] computingOptimizedStackHeight(List<Shape> rotatedShapes) {
        AtomicInteger height = new AtomicInteger();
        final int[] maxStackHeights = rotatedShapes.stream().mapToInt(Shape::getHeight).toArray();
        for (int i = 0; i < rotatedShapes.size(); i++) {
            maxStackHeights[i] = 0;
            final Shape block = rotatedShapes.get(i);
            height.set(0);
            for (int j = 0; j < i; j++) {
                final Shape prevBlock = rotatedShapes.get(j);
                if (subsetShapes.isSubset(prevBlock, block)) {
                    height.set(Math.max(height.get(), maxStackHeights[j]));
                }
            }
            maxStackHeights[i] = height.get() + block.getHeight();
        }
        return maxStackHeights;
    }

    private static class StackHeightHelper {
        private static final StackHeight INSTANCE = new StackHeight();
    }
}
