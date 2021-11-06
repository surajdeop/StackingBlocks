package org.anz.rotate;

import org.anz.factory.BlockFactory;
import org.anz.models.Shape;
import org.anz.rotate.impl.RotateCube;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class RotateCubeTest {
    private int edge;
    private BlockFactory blockFactory;

    @Before
    public void setup() {
        edge = 2;
        blockFactory = BlockFactory.getInstance();
    }

    @Test
    public void rotateCube() {
        Shape block = blockFactory.createBlock(edge, edge, edge);
        RotateShape rotateShape = RotateCube.getInstance(block);
        assertNotNull(rotateShape);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Set<Shape>> result = executor.submit(rotateShape);
        try {
            Set<Shape> shapes = result.get();
            assertEquals(1, shapes.size());
        }catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void checkRotateCube() {
        Shape block = blockFactory.createBlock(edge, edge, edge);
        RotateShape rotateShape = RotateCube.getInstance(block);
        assertNotNull(rotateShape);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Set<Shape>> result = executor.submit(rotateShape);
        try {
            Set<Shape> shapes = result.get();
            assertEquals(1, shapes.size());
            Shape rotatedBlock = blockFactory.createBlock(edge, edge, edge);
            assertTrue(shapes.contains(rotatedBlock));
        }catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}