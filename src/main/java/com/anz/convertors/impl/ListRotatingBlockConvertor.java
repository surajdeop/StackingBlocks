package com.anz.convertors.impl;

import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.models.Block;
import com.anz.models.RotatedBlock;

public final class ListRotatingBlockConvertor implements Convertor<String, Block[]> {
    private final Convertor<String, RotatedBlock[]> inputListBlockConvertor;
    private ListRotatingBlockConvertor() {
        inputListBlockConvertor = InputListBlockConvertor.getInstance();
    }

    public static Convertor<String, Block[]> getInstance() {
        return ListRotatingBlockConvertorHelper.INSTANCE;
    }

    @Override
    public Block[] convert(String input) throws InvalidInputException {
        final RotatedBlock[] rotatedBlocks = inputListBlockConvertor.convert(input);
        int blockSize = rotatedBlocks.length;
        final Block[] rotatingBlocks = new Block[blockSize * 3];
        for (int i = 0; i < blockSize; i++) {
            RotatedBlock rotatedBlock = rotatedBlocks[i];
            rotatingBlocks[3 * i] = rotatedBlock.getOriginalBlock();
            rotatingBlocks[3 * i + 1] = rotatedBlock.getFirstRotatedBlock();
            rotatingBlocks[3 * i + 2] = rotatedBlock.getSecondRotatedBlock();
        }
        return rotatingBlocks;
    }

    private static class ListRotatingBlockConvertorHelper {
        private static final Convertor<String, Block[]> INSTANCE = new ListRotatingBlockConvertor();
    }
}