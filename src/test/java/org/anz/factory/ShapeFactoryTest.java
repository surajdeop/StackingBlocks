package org.anz.factory;

import org.anz.models.Shape;
import org.anz.models.impl.Block;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeFactoryTest {
    @Test
    public void createShape() {
        ShapeFactory shapeFactory = ShapeFactory.getInstance();
        Shape shape = shapeFactory.createShape(ShapeFactory.ShapeType.CUBOID.name(), 1, 2, 3);
        assertNotNull(shape);
        assertTrue(shape instanceof Block);
    }

    @Test
    public void nullShape() {
        ShapeFactory shapeFactory = ShapeFactory.getInstance();
        Shape shape = shapeFactory.createShape("CustomeShape", 1, 2, 3);
        assertNull(shape);
    }

}
