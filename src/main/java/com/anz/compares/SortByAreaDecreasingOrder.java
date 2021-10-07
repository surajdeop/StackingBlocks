package com.anz.compares;

import com.anz.models.Block;

import java.util.Comparator;

/**
 * Sorting the block.
 */
public final class SortByAreaDecreasingOrder implements Comparator<Block> {

    @Override
    public int compare(Block block, Block nextBlock) {
        return nextBlock.getWidth() * nextBlock.getHeight() - block.getWidth() * block.getHeight();
    }
}
