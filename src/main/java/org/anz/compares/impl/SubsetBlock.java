package org.anz.compares.impl;

import org.anz.compares.Subset;
import org.anz.models.Shape;
import org.anz.models.impl.Block;

public class SubsetBlock implements Subset<Block> {

    private SubsetBlock() {
    }

    public static SubsetBlock getInstance() {
        return SubsetBlockHelper.INSTANCE;
    }

    @Override
    public boolean isSubset(Block block, Block nextBlock) {
        return block.getWidth() >= nextBlock.getWidth()
                && block.getLength() >= nextBlock.getLength()
                && block.getHeight() >= nextBlock.getHeight();
    }

    private static class SubsetBlockHelper {
        private static final SubsetBlock INSTANCE = new SubsetBlock();
    }
}
