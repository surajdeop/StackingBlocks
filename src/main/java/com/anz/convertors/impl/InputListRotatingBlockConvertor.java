package com.anz.convertors.impl;
import com.anz.convertors.Convertor;
import com.anz.exception.InvalidInputException;
import com.anz.models.Block;

public final class InputListRotatingBlockConvertor implements Convertor<String, Block[]> {
    private final Convertor<String, Block[]> listRotatingBlockConvertor;

    private InputListRotatingBlockConvertor() {
        listRotatingBlockConvertor = ListRotatingBlockConvertor.getInstance();
    }

    public static Convertor<String, Block[]> getInstance() {
        return InputListRotatingBlockConvertorHelper.INSTANCE;
    }

    @Override
    public Block[] convert(String input) throws InvalidInputException {
        return listRotatingBlockConvertor.convert(input);
    }

    private static class InputListRotatingBlockConvertorHelper {
        private static final Convertor<String, Block[]> INSTANCE = new InputListRotatingBlockConvertor();
    }

}