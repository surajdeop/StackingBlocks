package com.anz.convertors;

import com.anz.exception.InvalidInputException;

public interface Convertor<I, R> {
    R convert(I input) throws InvalidInputException;
}
