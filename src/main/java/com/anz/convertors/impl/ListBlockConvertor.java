package com.anz.convertors.impl;

import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.models.RotatedBlock;

/**
 * Convert to list of block from Input.
 */
public final class ListBlockConvertor implements Convertor<String, RotatedBlock[]> {
    private final Convertor<String, String[]> inputConvertor;
    private final Convertor<String, RotatedBlock> rotatingBlockConvertor;

    private ListBlockConvertor() {
        inputConvertor = InputConvertor.getInstance();
        rotatingBlockConvertor = RotatedBlockConvertor.getInstance();
    }

    public static Convertor<String, RotatedBlock[]> getInstance() {
        return ListBlockConvertorHelper.INSTANCE;
    }

    @Override
    public RotatedBlock[] convert(String input) throws InvalidInputException {
        final String[] blockStrArr = inputConvertor.convert(input);
        int blockSize = blockStrArr.length;
        final RotatedBlock[] rotatedBlocks = new RotatedBlock[blockSize];
        for (int i = 0; i < blockSize; i++) {
            rotatedBlocks[i] = rotatingBlockConvertor.convert(blockStrArr[i]);
        }
        return rotatedBlocks;
    }

    private static class ListBlockConvertorHelper {
        private static final Convertor<String, RotatedBlock[]> INSTANCE = new ListBlockConvertor();
    }
}