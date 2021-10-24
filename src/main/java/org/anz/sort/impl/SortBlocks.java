package org.anz.sort.impl;

import org.anz.models.Shape;
import org.anz.sort.SortShapes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortBlocks implements SortShapes {
    private SortBlocks() {
    }

    public static SortShapes getInstance() {
        return SortBlocksHelper.INSTANCE;
    }

    @Override
    public void sort(List<Shape> shapes) {
        Collections.sort(shapes, new SortByAreaDecreasingOrder());
    }

    private static class SortBlocksHelper {
        private static final SortShapes INSTANCE = new SortBlocks();
    }

    /**
     * Sorting the shapes on the bases of Area in decreasing order.
     */
    private static class SortByAreaDecreasingOrder implements Comparator<Shape> {

        @Override
        public int compare(Shape shape1, Shape shape2) {
            return Integer.compare(shape2.area(), shape1.area());
        }
    }
}
