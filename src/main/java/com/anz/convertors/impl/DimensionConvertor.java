package com.anz.convertors.impl;

import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.validations.NullEmptyCheck;
import com.anz.validations.RangeCheck;

import java.util.Arrays;

/**
 * Convert to Dimension from Input.
 */
public final class DimensionConvertor implements Convertor<String, int[]>, RangeCheck, NullEmptyCheck<String> {

    private DimensionConvertor() {
    }

    public static Convertor<String, int[]> getInstance() {
        return DimensionConvertorHelper.INSTANCE;
    }

    @Override
    public int[] convert(String blockInput) throws InvalidInputException{
        if (emptyCheck(blockInput)) {
            throw new InvalidInputException("Empty Block Inputs, size of dimension must be 3 number separated by comma");
        }
        return Arrays.stream(blockInput.split(","))
                .map(String::trim).mapToInt(Integer::parseInt)
                .filter(this::rangeBetweenOneToHundred).toArray();
    }

    private static class DimensionConvertorHelper {
        private static final Convertor<String, int[]> INSTANCE = new DimensionConvertor();
    }
}
