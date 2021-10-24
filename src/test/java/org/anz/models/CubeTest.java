package org.anz.models;

import org.anz.models.impl.Block;
import org.anz.models.impl.Cube;
import org.anz.models.impl.Cuboid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CubeTest {

    private Cube cube;
    private int edge;

    @Before
    public void setup() {
        edge = 2;
        cube = new Cube(edge);
    }


    @Test
    public void createBlockWithDimension() {
        assertNotNull(cube);
    }

    @Test
    public void checkBlockWithDimension() {
        assertTrue(cube instanceof Block);
        assertEquals(edge, ((Block) cube).getWidth());
        assertEquals(edge, ((Block) cube).getLength());
        assertEquals(edge, cube.getHeight());
    }

    @Test
    public void getArea() {
        assertEquals(edge * edge, cube.area());
    }

    @Test
    public void testEquality() {
        assertFalse(cube.equals(null));
        assertTrue(cube.equals(cube));
        Cube block2 = new Cube(edge);
        assertNotNull(block2);
        assertEquals(cube, block2);
        assertTrue(cube.equals(block2) && block2.equals(cube));
        assertTrue(cube.hashCode() == block2.hashCode());
        Cuboid cuboid = new Cuboid(edge, edge, edge);
        assertFalse(cube.equals(cuboid));

        Cube anotherCube = new Cube(edge + 1);
        assertFalse(cube.equals(anotherCube));
    }

    @Test
    public void testToString() {
        assertEquals("Cube{edge=2}", cube.toString());

    }
}
