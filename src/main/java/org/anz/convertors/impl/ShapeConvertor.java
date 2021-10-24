package org.anz.convertors.impl;


import org.anz.convertors.Convertor;
import org.anz.exception.InvalidInputException;
import org.anz.factory.BlockFactory;
import org.anz.models.Shape;
import org.anz.utils.ShapeUtils;

/**
 * Convert to block from Input.
 */
public final class ShapeConvertor implements Convertor<String, Shape> {
    private final Convertor<String, int[]> dimensionConvertor;
    private final BlockFactory blockFactory;

    private ShapeConvertor() {
        dimensionConvertor = DimensionConvertor.getInstance();
        blockFactory = BlockFactory.getInstance();
    }

    public static Convertor<String, Shape> getInstance() {
        return BlockConvertorHelper.INSTANCE;
    }

    @Override
    public Shape convert(String dimensionsStr) throws InvalidInputException {
        int[] dimensions = dimensionConvertor.convert(dimensionsStr);

        if (!ShapeUtils.isDimensionSizeThree(dimensions)) {
            throw new InvalidInputException("Invalid Block Inputs, size of dimension must be 3 number separated by comma or dimension may not lie between 1 to 100");
        }
        return blockFactory.createBlock(dimensions[0], dimensions[1], dimensions[2]);
    }

    private static class BlockConvertorHelper {
        private static final Convertor<String, Shape> INSTANCE = new ShapeConvertor();
    }
}
