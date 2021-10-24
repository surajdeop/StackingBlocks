package org.anz.sort;

import org.anz.models.Shape;

import java.util.List;

public interface SortShapes {
    /**
     * Sorting the shapes.
     *
     * @param shapes - Shapes list to be sorted
     */
    void sort(List<Shape> shapes);
}
