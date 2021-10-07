package com.anz.validations;

public interface RangeCheck {
    default boolean rangeBetweenOneToHundred(int input) {
        return 1 <= input && input <= 100;
    }

    default boolean isDimensionSizeThree(int[] dimensions) {
        return dimensions.length == 3;
    }
}