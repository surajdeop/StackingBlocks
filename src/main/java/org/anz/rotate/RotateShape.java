package org.anz.rotate;

import org.anz.models.Shape;

import java.util.Set;

/**
 * New Array of shapes is created
 *
 * @param @Shape
 */
public interface RotateShape {
    /**
     * New Array of shapes is created - considering all possible rotations
     *
     * @param shape
     * @return array of shapes
     */
    Set<Shape> rotate(Shape shape);
}
