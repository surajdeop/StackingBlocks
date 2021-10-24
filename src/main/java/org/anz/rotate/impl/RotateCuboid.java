package org.anz.rotate.impl;

import org.anz.factory.BlockFactory;
import org.anz.models.Shape;
import org.anz.models.impl.Cuboid;
import org.anz.rotate.RotateShape;

import java.util.HashSet;
import java.util.Set;

public class RotateCuboid implements RotateShape {
    private final BlockFactory blockFactory;

    private RotateCuboid() {
        blockFactory = BlockFactory.getInstance();
    }

    public static RotateShape getInstance() {
        return RotateCuboidHelper.INSTANCE;
    }

    /**
     * New Array of cuboid is created -
     * considering all 3 possible rotations, with width always greater than equal to width
     *
     * @param shape - pass actual shape
     * @return array of blocks
     */
    @Override
    public Set<Shape> rotate(Shape shape) {
        Set<Shape> shapes = new HashSet<>();
        Cuboid cuboid = (Cuboid) shape;

        /* First rotation of cuboid*/
        shapes.add(blockFactory.createBlock(Math.max(cuboid.getWidth(), cuboid.getLength()),
                Math.min(cuboid.getWidth(), cuboid.getLength()), cuboid.getHeight()));

        /* Second rotation of cuboid*/
        shapes.add(blockFactory.createBlock(Math.max(cuboid.getHeight(), cuboid.getLength()),
                Math.min(cuboid.getHeight(), cuboid.getLength()), cuboid.getWidth()));

        /* Third rotation of cuboid*/
        shapes.add(blockFactory.createBlock(Math.max(cuboid.getWidth(), cuboid.getHeight()),
                Math.min(cuboid.getWidth(), cuboid.getHeight()), cuboid.getLength()));
        return shapes;
    }

    private static class RotateCuboidHelper {
        private static final RotateShape INSTANCE = new RotateCuboid();
    }
}
