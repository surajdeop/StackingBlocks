package org.anz.rotate;

import org.anz.factory.BlockFactory;
import org.anz.factory.RotateShapeFactory;
import org.anz.models.Shape;
import org.anz.rotate.impl.RotateCuboid;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RotateCuboidTest {
    private int width;
    private int length;
    private int height;
    private BlockFactory blockFactory;
    private RotateShape rotateShape;

    @Before
    public void setup() {
        width = 1;
        length = 2;
        height = 3;
        blockFactory = BlockFactory.getInstance();
        rotateShape = RotateCuboid.getInstance();
    }

    @Test
    public void rotateShape() {
        assertNotNull(rotateShape);
    }

    @Test
    public void rotateCuboid() {
        rotateShape = RotateCuboid.getInstance();
        assertNotNull(rotateShape);
        Shape block = blockFactory.createBlock(width, length, height);
        Set<Shape> shapes = rotateShape.rotate(block);
        assertEquals(3, shapes.size());
    }

    @Test
    public void checkRotateCuboid() {
        rotateShape = RotateCuboid.getInstance();
        assertNotNull(rotateShape);
        Shape block = blockFactory.createBlock(width, length, height);
        Set<Shape> shapes = rotateShape.rotate(block);
        assertEquals(3, shapes.size());

        Shape rotatedBlock1 = blockFactory.createBlock(height, length, width);
        Shape rotatedBlock2 = blockFactory.createBlock(height, width, length);
        Shape rotatedBlock3 = blockFactory.createBlock(length, width, height);
        assertTrue(shapes.contains(rotatedBlock1));
        assertTrue(shapes.contains(rotatedBlock2));
        assertTrue(shapes.contains(rotatedBlock3));

    }

    @Test
    public void rotateSameCuboid() {
        Shape first = blockFactory.createBlock(2, 3, 1);
        Shape second = blockFactory.createBlock(1, 2, 3);
        Set<Shape> shapes1 = RotateShapeFactory.getInstance().createRotateShape(first).rotate(first);
        Set<Shape> shapes2 = RotateShapeFactory.getInstance().createRotateShape(second).rotate(second);
        Set<Set<Shape>> shapeList = new HashSet<>();
        shapeList.add(shapes1);
        shapeList.add(shapes2);

        assertEquals(1, shapeList.size());
    }
}
