package org.anz.sort;

import org.anz.factory.BlockFactory;
import org.anz.models.Shape;
import org.anz.sort.impl.SortBlocks;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortBlocksTest {
    @Test
    public void checkSortBlocks() {
        SortShapes sortBlocks = SortBlocks.getInstance();
        BlockFactory blockFactory = BlockFactory.getInstance();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(blockFactory.createBlock(1, 2, 1));
        shapes.add(blockFactory.createBlock(2, 3, 2));
        shapes.add(blockFactory.createBlock(1, 4, 3));

        sortBlocks.sort(shapes);

        assertEquals(2 * 3, shapes.get(0).area());
        assertEquals(1 * 4, shapes.get(1).area());
        assertEquals(1 * 2, shapes.get(2).area());
    }
}
