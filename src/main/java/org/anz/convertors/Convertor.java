package org.anz.convertors;

import org.anz.exception.InvalidInputException;

public interface Convertor<I, R> {
    R convert(I input) throws InvalidInputException;
}
