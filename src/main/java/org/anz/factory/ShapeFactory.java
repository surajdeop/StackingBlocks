package org.anz.factory;

import org.anz.models.Shape;
import org.anz.models.impl.Cube;
import org.anz.models.impl.Cuboid;

public class ShapeFactory {
    private ShapeFactory() {
    }

    public static ShapeFactory getInstance() {
        return ShapeFactoryHelper.INSTANCE;
    }

    /**
     * Create Shape
     *
     * @param shapeType - Shape type
     * @param dimension - Define dimension for shape
     * @return Shape Object
     */
    public Shape createShape(String shapeType, int... dimension) {
        final Shape shape;
        if ("CUBOID".equalsIgnoreCase(shapeType)) {
            int width = dimension[0];
            int length = dimension[1];
            int height = dimension[2];
            shape = new Cuboid(width, length, height);
        } else if ("CUBE".equalsIgnoreCase(shapeType)) {
            int edge = dimension[0];
            shape = new Cube(edge);
        } else
            shape = null;

        return shape;
    }

    //Define the type and create the shape object
    public enum ShapeType {
        CUBE, CUBOID
    }

    private static class ShapeFactoryHelper {
        private static final ShapeFactory INSTANCE = new ShapeFactory();
    }
}
