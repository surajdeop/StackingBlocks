package org.anz.models;

import org.anz.models.impl.Block;
import org.anz.models.impl.Cube;
import org.anz.models.impl.Cuboid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CuboidTest {
    private Cuboid cuboid;
    private int width;
    private int length;
    private int height;

    @Before
    public void setup() {
        width = 1;
        length = 2;
        height = 3;
        cuboid = new Cuboid(width, length, height);
    }


    @Test
    public void createBlockWithDimension() {
        assertNotNull(cuboid);
    }

    @Test
    public void checkBlockWithDimension() {
        assertTrue(cuboid instanceof Block);
        assertEquals(width, ((Cuboid) cuboid).getWidth());
        assertEquals(length, ((Cuboid) cuboid).getLength());
        assertEquals(height, cuboid.getHeight());
    }

    @Test
    public void getArea() {
        assertEquals(width * length, cuboid.area());
    }

    @Test
    public void testEquality() {
        assertFalse(cuboid.equals(null));
        assertTrue(cuboid.equals(cuboid));
        Cuboid block2 = new Cuboid(width, length, height);
        assertNotNull(block2);
        assertEquals(cuboid, block2);
        assertTrue(cuboid.equals(block2) && block2.equals(cuboid));
        assertTrue(cuboid.hashCode() == block2.hashCode());
        Cube cube = new Cube(width);
        assertFalse(cuboid.equals(cube));

        Cuboid cuboid2 = new Cuboid(1, 2, 4);
        assertFalse(cuboid.equals(cuboid2));
        cuboid2 = new Cuboid(1, 1, 3);
        assertFalse(cuboid.equals(cuboid2));
        cuboid2 = new Cuboid(2, 2, 3);
        assertFalse(cuboid.equals(cuboid2));
    }

    @Test
    public void testToString() {
        assertEquals("Cuboid{width=1, length=2, height=3}", cuboid.toString());

    }
}
