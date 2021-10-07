package com.anz.convertors.impl;

import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.models.Block;
import com.anz.validations.RangeCheck;

/**
 * Convert to block from Input.
 */
public final class BlockConvertor implements Convertor<String, Block>, RangeCheck {
    private final Convertor<String, int[]> dimensionConvertor;
    private BlockConvertor() {
        dimensionConvertor = DimensionConvertor.getInstance();
    }

    public static Convertor<String, Block> getInstance() {
        return BlockConvertorHelper.INSTANCE;
    }

    @Override
    public Block convert(String dimensionsStr) throws InvalidInputException {
        int[] dimensions = dimensionConvertor.convert(dimensionsStr);
        if (!isDimensionSizeThree(dimensions)) {
            throw new InvalidInputException("Invalid Block Inputs, size of dimension must be 3 number separated by comma");
        }
        return new Block(dimensions);
    }

    private static class BlockConvertorHelper {
        private static final Convertor<String, Block> INSTANCE = new BlockConvertor();
    }
}
