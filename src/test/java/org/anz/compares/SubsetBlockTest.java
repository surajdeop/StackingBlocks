package org.anz.compares;

import org.anz.compares.impl.SubsetBlock;
import org.anz.factory.BlockFactory;
import org.anz.models.Shape;
import org.anz.models.impl.Block;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubsetBlockTest {
    private BlockFactory blockFactory;

    @Before
    public void setup() {
        blockFactory = BlockFactory.getInstance();
    }

    @Test
    public void subsetTest() {
        Block first = blockFactory.createBlock(2, 3, 4);
        Block second = blockFactory.createBlock(1, 2, 3);
        Assert.assertTrue(SubsetBlock.getInstance().isSubset(first, second));
    }

    @Test
    public void notSubsetTest() {
        Block first = blockFactory.createBlock(2, 3, 4);
        Block second = blockFactory.createBlock(1, 2, 3);
        Assert.assertFalse(SubsetBlock.getInstance().isSubset(second, first));
    }

    @Test
    public void checkSubsetTest() {
        Block first = blockFactory.createBlock(2, 3, 4);

        Block second = new Block() {
            @Override
            public int getHeight() {
                return 0;
            }

            @Override
            public int getWidth() {
                return 0;
            }

            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public int area() {
                return 0;
            }
        };
        Assert.assertFalse(SubsetBlock.getInstance().isSubset(second, first));
    }
}
