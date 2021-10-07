package com.anz;

import com.anz.compares.SortByAreaDecreasingOrder;
import com.anz.compute.ComputeStackHeight;
import com.anz.convertors.Convertor;
import com.anz.convertors.impl.InputListRotatingBlockConvertor;
import com.anz.exception.InvalidInputException;
import com.anz.models.Block;

import java.util.Arrays;

public class StackHeight {

    private final Convertor<String, Block[]> inputRotatingBlockConvertor;
    private final ComputeStackHeight computeStackHeight;
    private final String input;

    {
        inputRotatingBlockConvertor = InputListRotatingBlockConvertor.getInstance();
        computeStackHeight = ComputeStackHeight.getInstance();
    }

    public StackHeight(String input) {
        this.input = input;
    }

    public int getMaxStackHeight() {
        int maxStackHeight = 0;
        try {
            final Block[] blocks = inputRotatingBlockConvertor.convert(input);
            /* Sorting the blocks on the bases of Area in decreasing order.*/
            Arrays.sort(blocks, new SortByAreaDecreasingOrder());
            /* Computing optimized maxStackHeightsArr[] values in bottom up manner */
            int[] maxStackHeightsArr = computeStackHeight.computingOptimizedStackHeight(blocks);
            /* Pick maximum of all maxStackHeightsArr values */
            maxStackHeight = Arrays.stream(maxStackHeightsArr).max().orElse(0);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        return maxStackHeight;
    }
}