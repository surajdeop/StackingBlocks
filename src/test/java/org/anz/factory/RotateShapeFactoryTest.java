package org.anz.factory;

import org.anz.models.Shape;
import org.anz.rotate.RotateShape;
import org.anz.rotate.impl.RotateCube;
import org.anz.rotate.impl.RotateCuboid;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateShapeFactoryTest {
    @Test
    public void createRotateCuboid() {
        Shape shape = BlockFactory.getInstance().createBlock(1, 2, 3);
        RotateShapeFactory rotateShapeFactory = RotateShapeFactory.getInstance();
        RotateShape rotateBlock = rotateShapeFactory.createRotateShape(shape);
        assertNotNull(rotateBlock);
        assertTrue(rotateBlock instanceof RotateCuboid);
    }

    @Test
    public void createRotateCube() {
        Shape shape = BlockFactory.getInstance().createBlock(2, 2, 2);
        RotateShapeFactory rotateShapeFactory = RotateShapeFactory.getInstance();
        RotateShape rotateBlock = rotateShapeFactory.createRotateShape(shape);
        assertNotNull(rotateBlock);
        assertTrue(rotateBlock instanceof RotateCube);
    }

    @Test
    public void createRotateShape() {

        Shape shape = new Shape() {
            @Override
            public int getHeight() {
                return 0;
            }

            @Override
            public int area() {
                return 0;
            }
        };
        RotateShapeFactory rotateShapeFactory = RotateShapeFactory.getInstance();
        RotateShape rotateBlock = rotateShapeFactory.createRotateShape(shape);
        assertNull(rotateBlock);
    }
}
