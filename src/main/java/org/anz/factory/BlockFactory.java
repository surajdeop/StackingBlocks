package org.anz.factory;

import org.anz.models.Shape;
import org.anz.models.impl.Block;
import org.anz.models.impl.Cube;
import org.anz.models.impl.Cuboid;

public class BlockFactory {
    private final ShapeFactory shapeFactory;

    private BlockFactory() {
        shapeFactory = ShapeFactory.getInstance();
    }

    public static BlockFactory getInstance() {
        return BlockFactoryHelper.INSTANCE;
    }

    public Block createBlock(int width, int length, int height) {
        final Block shape;
        if (width == length && length == height) {
            shape = (Cube)shapeFactory.createShape(ShapeFactory.ShapeType.CUBE.name(), width);
        } else {
            shape = (Cuboid)shapeFactory.createShape(ShapeFactory.ShapeType.CUBOID.name(), width, length, height);
        }
        return shape;
    }

    private static class BlockFactoryHelper {
        private static final BlockFactory INSTANCE = new BlockFactory();
    }
}
