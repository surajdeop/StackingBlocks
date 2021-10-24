package org.anz.convertors;

import org.anz.convertors.impl.InputConvertor;
import org.anz.exception.InvalidInputException;
import org.anz.utils.ShapeUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputConvertorTest {
    private Convertor<String, String[]> inputConvertor;


    @Before
    public void setUp() {
        inputConvertor = InputConvertor.getInstance();
    }

    @Test
    public void inputBlockSizeValidation() {
        String input = "[[1,2,3],[3,4,5]]";
        String[] blocks;
        try {
            blocks = inputConvertor.convert(input);
            assertTrue(ShapeUtils.rangeBetweenOneToHundred(blocks.length));
        } catch (InvalidInputException e) {
            //e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void inputBlockSizeValidationFailed() {
        String input = "";
        String[] blocks;
        try {
            blocks = inputConvertor.convert(input);
            assertFalse(ShapeUtils.rangeBetweenOneToHundred(blocks.length));
        } catch (InvalidInputException e) {
            //e.printStackTrace();
            assertEquals("Empty input, it must be in range of 1 to 100.", e.getMessage());
        }
    }

    @Test
    public void inputBlockSizeValidatioMoreThan100() {
        StringBuilder input = new StringBuilder();
        input.append("[");
        for (int i = 0; i < 100; i++) {
            input.append("[1,2,3],");
        }
        input.append("[1,2,3]]");

        String[] blocks;
        try {
            blocks = inputConvertor.convert(input.toString());
        } catch (InvalidInputException e) {
            //e.printStackTrace();
            assertEquals("Input block must be in range of 1 to 100.", e.getMessage());
        }
    }
}
