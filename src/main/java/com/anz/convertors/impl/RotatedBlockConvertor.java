package com.anz.convertors.impl;

import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.models.Block;
import com.anz.models.RotatedBlock;
/**
 * Convert to rotating block from Input to block.
 */
public final class RotatedBlockConvertor implements Convertor<String, RotatedBlock> {
    private final Convertor<String, Block> blockConvertor;
    private RotatedBlockConvertor() {
        blockConvertor = BlockConvertor.getInstance();
    }

    public static Convertor<String, RotatedBlock> getInstance() {
        return RotatedBlockConvertorHelper.INSTANCE;
    }

    /**
     * New List of blocks is created - considering all 3 possible rotations,
     * with width always greater than equal to width
     **/
    @Override
    public RotatedBlock convert(String blockStr)throws InvalidInputException {
        final Block block = blockConvertor.convert(blockStr);
        return new RotatedBlock(block);
    }

    private static class RotatedBlockConvertorHelper {
        private static final Convertor<String, RotatedBlock> INSTANCE = new RotatedBlockConvertor();
    }
}
