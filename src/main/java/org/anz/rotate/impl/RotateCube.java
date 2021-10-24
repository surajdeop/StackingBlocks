package org.anz.rotate.impl;

import org.anz.models.Shape;
import org.anz.rotate.RotateShape;

import java.util.HashSet;
import java.util.Set;

public class RotateCube implements RotateShape {

    private RotateCube() {
    }

    public static RotateShape getInstance() {
        return RotateCubeHelper.INSTANCE;
    }

    @Override
    public Set<Shape> rotate(Shape cube) {
        Set<Shape> shapes = new HashSet<>();
        shapes.add(cube);
        return shapes;
    }

    private static class RotateCubeHelper {
        private static final RotateShape INSTANCE = new RotateCube();
    }
}
