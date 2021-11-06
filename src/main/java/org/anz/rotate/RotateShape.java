package org.anz.rotate;

import org.anz.models.Shape;

import java.util.Set;
import java.util.concurrent.Callable;

/**
 * New Array of shapes is created
 *
 * @param @Shape
 */
public interface RotateShape extends Callable<Set<Shape>> {

}
