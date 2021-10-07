package com.anz.compares;

import com.anz.models.Block;

/**
 * Compare the blocks to put into another block.
 */
public final class CompareBlocks {
    private CompareBlocks() {
    }

    public static CompareBlocks getInstance() {
        return CompareBlocksHelper.INSTANCE;
    }

    public boolean compareBlocks(Block block, Block prevBlock) {
        return block.getWidth() <= prevBlock.getWidth()
                && block.getLength() <= prevBlock.getLength()
                && block.getHeight() <= prevBlock.getHeight();
    }

    private static class CompareBlocksHelper {
        private static final CompareBlocks INSTANCE = new CompareBlocks();
    }
}