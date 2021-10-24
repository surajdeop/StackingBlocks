package org.anz.rotate;

import org.anz.factory.BlockFactory;
import org.anz.models.Shape;
import org.anz.rotate.impl.RotateCube;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RotateCubeTest {
    private int edge;
    private BlockFactory blockFactory;
    private RotateShape rotateShape;

    @Before
    public void setup() {
        edge = 2;
        blockFactory = BlockFactory.getInstance();
        rotateShape = RotateCube.getInstance();
    }

    @Test
    public void rotateShape() {
        rotateShape = RotateCube.getInstance();
        assertNotNull(rotateShape);
    }

    @Test
    public void rotateCube() {
        rotateShape = RotateCube.getInstance();
        assertNotNull(rotateShape);
        Shape block = blockFactory.createBlock(edge, edge, edge);
        Set<Shape> shapes = rotateShape.rotate(block);
        assertEquals(1, shapes.size());
    }

    @Test
    public void checkRotateCube() {
        rotateShape = RotateCube.getInstance();
        assertNotNull(rotateShape);
        Shape block = blockFactory.createBlock(edge, edge, edge);
        Set<Shape> shapes = rotateShape.rotate(block);
        assertEquals(1, shapes.size());

        Shape rotatedBlock = blockFactory.createBlock(edge, edge, edge);
        assertTrue(shapes.contains(rotatedBlock));

    }
}