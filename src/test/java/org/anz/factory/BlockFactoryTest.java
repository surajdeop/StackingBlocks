package org.anz.factory;

import org.anz.models.Shape;
import org.anz.models.impl.Block;
import org.anz.models.impl.Cube;
import org.anz.models.impl.Cuboid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BlockFactoryTest {
    private BlockFactory blockFactory;

    @Before
    public void setup() {
        blockFactory = BlockFactory.getInstance();
    }

    @Test
    public void createBlock() {
        Shape shape = blockFactory.createBlock(1, 2, 3);
        assertNotNull(shape);
        assertTrue(shape instanceof Block);
        shape = blockFactory.createBlock(2, 2, 2);
        assertNotNull(shape);
        assertTrue(shape instanceof Block);
    }

    @Test
    public void createCuboid() {
        Shape shape = blockFactory.createBlock(1, 2, 3);
        assertNotNull(shape);
        assertTrue(shape instanceof Block);
        assertTrue(shape instanceof Cuboid);
    }

    @Test
    public void createCube() {
        Shape shape = blockFactory.createBlock(2, 2, 2);
        assertNotNull(shape);
        assertTrue(shape instanceof Block);
        assertTrue(shape instanceof Cube);
    }
}
