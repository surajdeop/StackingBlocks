package org.anz.rotate;

import org.anz.factory.BlockFactory;
import org.anz.factory.RotateShapeFactory;
import org.anz.models.Shape;
import org.anz.rotate.impl.RotateCuboid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class RotateCuboidTest {
    private int width;
    private int length;
    private int height;
    private BlockFactory blockFactory;

    @Before
    public void setup() {
        width = 1;
        length = 2;
        height = 3;
        blockFactory = BlockFactory.getInstance();
    }

    @Test
    public void rotateCuboid() {
        Shape block = blockFactory.createBlock(width, length, height);
        RotateShape rotateShape = RotateCuboid.getInstance(block);
        assertNotNull(rotateShape);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Set<Shape>> result = executor.submit(rotateShape);
        try {
            Set<Shape> shapes = result.get();
            assertEquals(3, shapes.size());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void checkRotateCuboid() {
        Shape block = blockFactory.createBlock(width, length, height);
        RotateShape rotateShape = RotateCuboid.getInstance(block);
        assertNotNull(rotateShape);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Set<Shape>> result = executor.submit(rotateShape);
        try {
            Set<Shape> shapes = result.get();
            assertEquals(3, shapes.size());
            Shape rotatedBlock1 = blockFactory.createBlock(height, length, width);
            Shape rotatedBlock2 = blockFactory.createBlock(height, width, length);
            Shape rotatedBlock3 = blockFactory.createBlock(length, width, height);
            assertTrue(shapes.contains(rotatedBlock1));
            assertTrue(shapes.contains(rotatedBlock2));
            assertTrue(shapes.contains(rotatedBlock3));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void rotateSameCuboid() {
        Shape first = blockFactory.createBlock(2, 3, 1);
        Shape second = blockFactory.createBlock(1, 2, 3);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Set<Shape>>> tasks = new ArrayList<>();

        tasks.add(executor.submit(RotateShapeFactory.getInstance().createRotateShape(first)));
        tasks.add(executor.submit(RotateShapeFactory.getInstance().createRotateShape(second)));

        Set<Set<Shape>> shapeList = new HashSet<>();
        try {
            for (Future<Set<Shape>> task : tasks) {
                shapeList.add(task.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            fail();
        }

        assertEquals(1, shapeList.size());
    }
}
