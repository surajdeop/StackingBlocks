package org.anz.utils;

import org.anz.factory.BlockFactory;
import org.anz.factory.RotateShapeFactory;
import org.anz.models.Shape;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShapeUtilsTest {

    @Test
    public void isRearrangingWithSameDimension() {
        Shape first = BlockFactory.getInstance().createBlock(2, 3, 1);
        Shape second = BlockFactory.getInstance().createBlock(1, 2, 3);

        List<Set<Shape>> rotatedShapes = new ArrayList<>();
        rotatedShapes.add(RotateShapeFactory.getInstance().createRotateShape(first).rotate(first));
        rotatedShapes.add(RotateShapeFactory.getInstance().createRotateShape(second).rotate(second));

        assertTrue(ShapeUtils.isRearrangingWithSameDimension(rotatedShapes));

    }

    @Test
    public void isRearrangingWithSameDimensionFailed() {
        Shape first = BlockFactory.getInstance().createBlock(2, 3, 1);
        Shape second = BlockFactory.getInstance().createBlock(2, 2, 3);

        List<Set<Shape>> rotatedShapes = new ArrayList<>();

        rotatedShapes.add(RotateShapeFactory.getInstance().createRotateShape(first).rotate(first));
        rotatedShapes.add(RotateShapeFactory.getInstance().createRotateShape(second).rotate(second));

        assertFalse(ShapeUtils.isRearrangingWithSameDimension(rotatedShapes));
    }

    @Test
    public void rangeBetweenOneToHundred() {
        assertTrue(ShapeUtils.rangeBetweenOneToHundred(10));
        assertFalse(ShapeUtils.rangeBetweenOneToHundred(101));
        assertFalse(ShapeUtils.rangeBetweenOneToHundred(-10));
        assertFalse(ShapeUtils.rangeBetweenOneToHundred(0));
    }

    @Test
    public void isDimensionSizeThree() {
        assertFalse(ShapeUtils.isDimensionSizeThree());
        assertTrue(ShapeUtils.isDimensionSizeThree(1, 2, 3));
        assertTrue(ShapeUtils.isDimensionSizeThree(1, 2, 3));
        assertFalse(ShapeUtils.isDimensionSizeThree(1, 2));
    }

    @Test
    public void nullCheck() {
        String str = null;
        assertTrue(ShapeUtils.isNull(str));
        assertFalse(ShapeUtils.isNotNull(str));
    }

    @Test
    public void notNullCheck() {
        String str = "null Check";
        assertTrue(ShapeUtils.isNotNull(str));
        assertFalse(ShapeUtils.isNull(str));
    }

    @Test
    public void emptyCheck() {
        String str = "";
        assertTrue(ShapeUtils.emptyString(str));
        assertFalse(ShapeUtils.emptyString(null));
    }

    @Test
    public void notEmptyCheck() {
        String str = "Not Empty";
        assertFalse(ShapeUtils.emptyString(str));
    }

}
