package com.anz.convertors.impl;

import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.models.RotatedBlock;

public final class InputListBlockConvertor implements Convertor<String, RotatedBlock[]> {
    private final Convertor<String, RotatedBlock[]> listBlockConvertor;

    private InputListBlockConvertor() {
        listBlockConvertor = ListBlockConvertor.getInstance();
    }

    public static Convertor<String, RotatedBlock[]> getInstance() {
        return InputListBlockConvertorHelper.INSTANCE;
    }

    @Override
    public RotatedBlock[] convert(String input) throws InvalidInputException {
        return listBlockConvertor.convert(input);
    }

    private static class InputListBlockConvertorHelper {
        private static final Convertor<String, RotatedBlock[]> INSTANCE = new InputListBlockConvertor();
    }
}
