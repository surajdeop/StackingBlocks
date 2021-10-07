package com.anz.validations;

import com.anz.convertors.Convertor;
import com.anz.convertors.impl.DimensionConvertor;
import com.anz.convertors.impl.InputConvertor;
import com.anz.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationTest {
    private Convertor<String, String[]> inputConvertor;
    private Convertor<String, int[]> dimensionConvertor;


    @Before
    public void setUp() {
        inputConvertor = InputConvertor.getInstance();
        dimensionConvertor = DimensionConvertor.getInstance();
    }

    @Test
    public void inputBlockSizeValidation() {
        String input = "[[1,2,3],[3,4,5]]";
        String[] blocks = new String[0];
        try {
            blocks = inputConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertTrue(new RangeCheck() {
        }.rangeBetweenOneToHundred(blocks.length));
    }

    @Test
    public void inputBlockSizeValidationFailed() {
        String input = "";
        String[] blocks = new String[0];
        try {
            blocks = inputConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertFalse(new RangeCheck() {
        }.rangeBetweenOneToHundred(blocks.length));
    }

    @Test
    public void blockInputSizeValidation() {
        String input = "1,2,3";
        int[] dimensions = new int[0];
        try {
            dimensions = dimensionConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertTrue(new RangeCheck() {
        }.isDimensionSizeThree(dimensions));
    }

    @Test
    public void blockInputSizeValidationFailed() {
        String input = "";
        int[] dimensions = new int[0];
        try {
            dimensions = dimensionConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertFalse(new RangeCheck() {
        }.isDimensionSizeThree(dimensions));
    }

    @Test
    public void blockWrongInputSizeValidationFailed() {
        String input = "1,2,3,4";
        int[] dimensions = new int[0];
        try {
            dimensions = dimensionConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertFalse(new RangeCheck() {
        }.isDimensionSizeThree(dimensions));
    }

}