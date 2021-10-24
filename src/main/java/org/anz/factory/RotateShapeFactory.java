package org.anz.factory;

import org.anz.models.Shape;
import org.anz.models.impl.Cube;
import org.anz.models.impl.Cuboid;
import org.anz.rotate.RotateShape;
import org.anz.rotate.impl.RotateCube;
import org.anz.rotate.impl.RotateCuboid;

public class RotateShapeFactory {
    private RotateShapeFactory() {
    }

    public static RotateShapeFactory getInstance() {
        return RotateShapeFactory.RotateShapeFactoryHelper.INSTANCE;
    }

    /**
     * Create Rotate Shape
     *
     * @param shape - Rotate Shape
     * @return Rotate Shape Object
     */
    public RotateShape createRotateShape(Shape shape) {
        final RotateShape rotateShape;
        if (shape instanceof Cube) {
            rotateShape = RotateCube.getInstance();
        } else if (shape instanceof Cuboid) {
            rotateShape = RotateCuboid.getInstance();
        } else {
            rotateShape = null;
        }
        return rotateShape;
    }


    private static class RotateShapeFactoryHelper {
        private static final RotateShapeFactory INSTANCE = new RotateShapeFactory();
    }
}
