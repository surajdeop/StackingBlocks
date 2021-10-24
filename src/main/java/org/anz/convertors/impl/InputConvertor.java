package org.anz.convertors.impl;


import org.anz.convertors.Convertor;
import org.anz.exception.InvalidInputException;
import org.anz.utils.ShapeUtils;

import java.util.regex.Pattern;

/**
 * Convert to blocks from Input.
 */

public final class InputConvertor implements Convertor<String, String[]> {

    private InputConvertor() {
    }

    public static Convertor<String, String[]> getInstance() {
        return InputConvertorHelper.INSTANCE;
    }

    @Override
    public String[] convert(String input) throws InvalidInputException {
        if (ShapeUtils.emptyString(input)) {
            throw new InvalidInputException("Empty input, it must be in range of 1 to 100.");
        }
        String[] blocks = Pattern.compile("],\\[")
                .splitAsStream(input.substring(2, input.length() - 2))
                .toArray(String[]::new);
        if (!ShapeUtils.rangeBetweenOneToHundred(blocks.length)) {
            throw new InvalidInputException("Input block must be in range of 1 to 100.");
        }
        return blocks;
    }

    private static class InputConvertorHelper {
        private static final Convertor<String, String[]> INSTANCE = new InputConvertor();
    }
}