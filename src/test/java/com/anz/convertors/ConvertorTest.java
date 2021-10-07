package com.anz.convertors;

import com.anz.convertors.impl.*;
import com.anz.exception.InvalidInputException;
import com.anz.models.Block;
import com.anz.models.RotatedBlock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConvertorTest {
    private Convertor<String, String[]> inputConvertor;
    private Convertor<String, int[]> dimensionConvertor;
    private Convertor<String, Block> blockConvertor;
    private Convertor<String, RotatedBlock[]> blockConvertorArray;
    private Convertor<String, RotatedBlock> rotatingBlockConvertor;
    private Convertor<String, Block[]> rotatingBlockConvertorArray;


    @Before
    public void setUp() {
        inputConvertor = InputConvertor.getInstance();
        dimensionConvertor = DimensionConvertor.getInstance();
        blockConvertor = BlockConvertor.getInstance();
        blockConvertorArray = ListBlockConvertor.getInstance();
        rotatingBlockConvertor = RotatedBlockConvertor.getInstance();
        rotatingBlockConvertorArray = ListRotatingBlockConvertor.getInstance();
    }

    @Test
    public void inputConvertor() {
        String input = "[[1,2,3],[3,4,5]]";
        String[] blocks = new String[0];
        try {
            blocks = inputConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertEquals(2, blocks.length);
        assertEquals("1,2,3", blocks[0]);
        assertEquals("3,4,5", blocks[1]);
    }

    @Test
    public void dimensionConvertor() {
        String input = "1,2,3";
        int[] dimension = new int[0];
        try {
            dimension = dimensionConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertEquals(3, dimension.length);
        assertEquals(1, dimension[0]);
        assertEquals(2, dimension[1]);
        assertEquals(3, dimension[2]);
    }

    @Test
    public void dimensionToBlockConvertor() {
        String input = "1,2,3";
        Block block = null;
        try {
            block = blockConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertNotNull(block);
        assertEquals(1, block.getWidth());
        assertEquals(2, block.getLength());
        assertEquals(3, block.getHeight());
    }

    @Test
    public void blockToRotatingBlockConvertor() {
        String input = "1,2,3";
        RotatedBlock rotatedBlocks = null;
        try {
            rotatedBlocks = rotatingBlockConvertor.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertNotNull(rotatedBlocks);
        assertNotNull(rotatedBlocks.getOriginalBlock());
        assertNotNull(rotatedBlocks.getFirstRotatedBlock());
        assertNotNull(rotatedBlocks.getSecondRotatedBlock());
    }

    @Test
    public void blockConvertorArrays() {
        String input = "[[1,2,3],[3,4,5]]";
        RotatedBlock[] blocks = new RotatedBlock[0];
        try {
            blocks = blockConvertorArray.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertEquals(2, blocks.length);
    }

    @Test
    public void rotatingBlockConvertorArrays() {
        String input = "[[1,2,3],[3,4,5]]";
        Block[] rotatingBlocks = new Block[0];
        try {
            rotatingBlocks = rotatingBlockConvertorArray.convert(input);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        assertEquals(6, rotatingBlocks.length);
    }


}