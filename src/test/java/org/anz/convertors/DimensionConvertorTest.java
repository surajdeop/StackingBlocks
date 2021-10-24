package org.anz.convertors;

import org.anz.convertors.impl.DimensionConvertor;
import org.anz.exception.InvalidInputException;
import org.anz.utils.ShapeUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DimensionConvertorTest {
    private Convertor<String, int[]> dimensionConvertor;


    @Before
    public void setUp() {
        dimensionConvertor = DimensionConvertor.getInstance();
    }

    @Test
    public void blockInputSizeValidation() {
        String input = "2,1,3";
        int[] dimensions;
        try {
            dimensions = dimensionConvertor.convert(input);
            assertTrue(ShapeUtils.isDimensionSizeThree(dimensions));
        } catch (InvalidInputException e) {
            //e.printStackTrace();
        }

    }

    @Test
    public void blockInputSizeValidationFailed() {
        String input = "";
        int[] dimensions;
        try {
            dimensions = dimensionConvertor.convert(input);
            assertFalse(ShapeUtils.isDimensionSizeThree(dimensions));
        } catch (InvalidInputException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void blockWrongInputSizeValidationFailed() {
        String input = "1,2,3,4";
        int[] dimensions;
        try {
            dimensions = dimensionConvertor.convert(input);
            assertFalse(ShapeUtils.isDimensionSizeThree(dimensions));
        } catch (InvalidInputException e) {
            //e.printStackTrace();
        }
    }
}
