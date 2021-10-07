package com.anz.compute;


import com.anz.compares.CompareBlocks;
import com.anz.models.Block;

import java.util.stream.Stream;
/**
 * Compute all possible stack height.
 */
public final class ComputeStackHeight {
    private final CompareBlocks compareBlocks;

    private ComputeStackHeight() {
        compareBlocks = CompareBlocks.getInstance();
    }

    public static ComputeStackHeight getInstance() {
        return ComputeStackHeightHelper.INSTANCE;
    }

    public int[] computingOptimizedStackHeight(Block[] rotatingBlocks) {
       /* Initialize msh values for all indexes
          msh[i] --> Maximum possible Stack Height with block i on top
       */
        final int blocksSize = rotatingBlocks.length;
        final int[] maxStackHeightsArr = Stream.of(rotatingBlocks).mapToInt(Block::getHeight).toArray();
        for (int i = 0; i < blocksSize; i++) {
            maxStackHeightsArr[i] = 0;
            final Block block = rotatingBlocks[i];
            int height = 0;
            for (int j = 0; j < i; j++) {
                final Block prevBlock = rotatingBlocks[j];
                if (compareBlocks.compareBlocks(block, prevBlock)) {
                    height = Math.max(height, maxStackHeightsArr[j]);
                }
            }
            maxStackHeightsArr[i] = height + block.getHeight();
        }
        return maxStackHeightsArr;
    }

    private static class ComputeStackHeightHelper {
        private static final ComputeStackHeight INSTANCE = new ComputeStackHeight();
    }
}