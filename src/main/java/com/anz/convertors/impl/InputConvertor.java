package com.anz.convertors.impl;

import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.validations.NullEmptyCheck;
import com.anz.validations.RangeCheck;

import java.util.regex.Pattern;

public final class InputConvertor implements Convertor<String, String[]>, NullEmptyCheck<String>, RangeCheck {

    private InputConvertor() {
    }

    public static Convertor<String, String[]> getInstance() {
        return InputConvertorHelper.INSTANCE;
    }

    @Override
    public String[] convert(String input) throws InvalidInputException{
        if (emptyCheck(input)) {
            throw new InvalidInputException("Empty input, it must be in range of 1 to 100.");
        }
        String[] blocks = Pattern.compile("],\\[")
                .splitAsStream(input.substring(2, input.length() - 2))
                .toArray(String[]::new);
        if (!rangeBetweenOneToHundred(blocks.length)) {
            throw new InvalidInputException("Input block must be in range of 1 to 100.");
        }
        return blocks;
    }

    private static class InputConvertorHelper {
        private static final Convertor<String, String[]> INSTANCE = new InputConvertor();
    }
}