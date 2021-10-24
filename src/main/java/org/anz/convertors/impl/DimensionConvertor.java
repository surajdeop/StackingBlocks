package org.anz.convertors.impl;


import org.anz.convertors.Convertor;
import org.anz.exception.InvalidInputException;
import org.anz.utils.ShapeUtils;

import java.util.Arrays;

/**
 * Convert to Dimension from Input.
 */
public final class DimensionConvertor implements Convertor<String, int[]> {

    private DimensionConvertor() {
    }

    public static Convertor<String, int[]> getInstance() {
        return DimensionConvertorHelper.INSTANCE;
    }

    @Override
    public int[] convert(String blockInput) throws InvalidInputException {
        if (ShapeUtils.emptyString(blockInput)) {
            throw new InvalidInputException("Empty Block Inputs, size of dimension must be 3 number separated by comma");
        }
        return Arrays.stream(blockInput.split(","))
                .map(String::trim).mapToInt(Integer::parseInt)
                .filter(ShapeUtils::rangeBetweenOneToHundred).toArray();
    }

    private static class DimensionConvertorHelper {
        private static final Convertor<String, int[]> INSTANCE = new DimensionConvertor();
    }
}
