package org.anz.utils;

import org.anz.factory.BlockFactory;
import org.anz.factory.RotateShapeFactory;
import org.anz.models.Shape;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class ShapeUtilsTest {

    @Test
    public void isRearrangingWithSameDimension() {
        Shape first = BlockFactory.getInstance().createBlock(2, 3, 1);
        Shape second = BlockFactory.getInstance().createBlock(1, 2, 3);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Set<Shape>>> tasks = new ArrayList<>();

        tasks.add(executor.submit(RotateShapeFactory.getInstance().createRotateShape(first)));
        tasks.add(executor.submit(RotateShapeFactory.getInstance().createRotateShape(second)));

        List<Set<Shape>> rotatedShapes = new ArrayList<>();
        try {
            for (Future<Set<Shape>> task:
                 tasks) {
                rotatedShapes.add(task.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            fail();
        }

        assertTrue(ShapeUtils.isRearrangingWithSameDimension(rotatedShapes));

    }

    @Test
    public void isRearrangingWithSameDimensionFailed() {
        Shape first = BlockFactory.getInstance().createBlock(2, 3, 1);
        Shape second = BlockFactory.getInstance().createBlock(2, 2, 3);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Set<Shape>>> tasks = new ArrayList<>();

        tasks.add(executor.submit(RotateShapeFactory.getInstance().createRotateShape(first)));
        tasks.add(executor.submit(RotateShapeFactory.getInstance().createRotateShape(second)));

        List<Set<Shape>> rotatedShapes = new ArrayList<>();
        try {
            for (Future<Set<Shape>> task:
                    tasks) {
                rotatedShapes.add(task.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            fail();
        }

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
