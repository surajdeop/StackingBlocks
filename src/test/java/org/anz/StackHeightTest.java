package org.anz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackHeightTest {
    private StackHeight stackHeight;

    @Before
    public void setup() {
        stackHeight = StackHeight.getInstance();
    }

    @Test
    public void useCase1() {
        String input = "[[50,45,20],[95,37,53],[45,23,12]]";
        assertEquals(190, stackHeight.getMaxStackHeight(input));
    }

    @Test
    public void useCase2() {
        String input = "[[38,25,45],[76,35,3]]";
        assertEquals(76, stackHeight.getMaxStackHeight(input));
    }

    @Test
    public void useCase3() {
        String input = "[[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]";
        assertEquals(102, stackHeight.getMaxStackHeight(input));
    }

    @Test
    public void useCase4_all_cubes() {
        String input = "[[7,7,7],[7,7,7],[7,7,7],[7,7,7],[7,7,7]]";
        assertEquals(35, stackHeight.getMaxStackHeight(input));
    }

    @Test
    public void useCase5_mix_cubes_coboid() {
        String input = "[[7,7,7],[38,25,45],[7,17,11],[7,7,7],[11,7,17],[76,35,3]]";
        assertEquals(93, stackHeight.getMaxStackHeight(input));
    }

    @Test
    public void failedUseCase() {
        String input = "[[7,11,17],[7,17,110],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]";
        try {
            stackHeight.getMaxStackHeight(input);
        } catch (Exception e) {
            assertEquals("Invalid Block Inputs, size of dimension must be 3 number separated by comma or dimension may not lie between 1 to 100", e.getMessage());
        }
    }
}
