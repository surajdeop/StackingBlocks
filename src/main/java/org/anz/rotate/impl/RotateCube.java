package org.anz.rotate.impl;

import org.anz.models.Shape;
import org.anz.rotate.RotateShape;

import java.util.HashSet;
import java.util.Set;

public class RotateCube implements RotateShape {
    private final Shape cube;

    private RotateCube(Shape shape) {
        this.cube = shape;
    }

    public static RotateShape getInstance(Shape shape) {
        return new RotateCube(shape);
    }

    /**
     * New Array of shapes is created - considering all possible rotations
     *
     * @param cube
     * @return array of shapes
     */
    private Set<Shape> rotate(Shape cube) {
        Set<Shape> shapes = new HashSet<>();
        shapes.add(cube);
        return shapes;
    }

    @Override
    public Set<Shape> call() throws Exception {
        return rotate(cube);
    }

}
