package org.anz.utils;

import org.anz.models.Shape;

import java.util.List;
import java.util.Set;

public final class ShapeUtils {
    private ShapeUtils() {
    }

    /**
     * After rearranging the blocks, you can see that all blocks have the same dimension.
     * @param rotatedShapes - Pass all rotated shape List
     * @return boolean value
     */
    public static boolean isRearrangingWithSameDimension(List<Set<Shape>> rotatedShapes) {
        return rotatedShapes.stream().distinct().count() == 1;
    }

    public static boolean rangeBetweenOneToHundred(int input) {
        return 1 <= input && input <= 100;
    }

    public static boolean isDimensionSizeThree(int... dimensions) {
        return dimensions.length == 3;
    }

    public static boolean isNull(Object obj) {
        return null == obj;
    }

    public static boolean isNotNull(Object obj) {
        return null != obj;
    }

    public static boolean emptyString(String str) {
        return isNotNull(str) && str.trim().isEmpty();
    }
}
