package org.anz.convertors;

import org.anz.convertors.impl.ShapeConvertor;
import org.anz.exception.InvalidInputException;
import org.anz.models.Shape;
import org.anz.models.impl.Block;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShapeConvertorTest {
    @Test
    public void dimensionToBlockConvertor() {
        String input = "1,2,3";
        Shape block = null;
        try {
            block = ShapeConvertor.getInstance().convert(input);
        } catch (InvalidInputException e) {
            //e.printStackTrace();
            Assert.fail();
        }
        assertNotNull(block);
        assertEquals(1, ((Block) block).getWidth());
        assertEquals(2, ((Block) block).getLength());
        assertEquals(3, block.getHeight());
    }

    @Test
    public void dimensionToBlockConvertorFailure() {
        String input = "3,2,1,4";
        Shape block = null;
        try {
            block = ShapeConvertor.getInstance().convert(input);
        } catch (InvalidInputException e) {
            //e.printStackTrace();
            assertEquals("Invalid Block Inputs, size of dimension must be 3 number separated by comma or dimension may not lie between 1 to 100", e.getMessage());
            //Assert.fail();
        }

    }
}
