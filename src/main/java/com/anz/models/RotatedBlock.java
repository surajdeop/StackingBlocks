package com.anz.models;

public final class RotatedBlock {
    private final Block originalBlock;
    private final Block firstRotatedBlock;
    private final Block secondRotatedBlock;

    public RotatedBlock(final Block block) {
        originalBlock = new Block(Math.max(block.getWidth(), block.getLength()),
                Math.min(block.getWidth(), block.getLength()), block.getHeight());

        /* First rotation of block*/
        firstRotatedBlock = new Block(Math.max(block.getHeight(), block.getLength()),
                Math.min(block.getHeight(), block.getLength()), block.getWidth());

        /* Second rotation of block*/
        secondRotatedBlock = new Block(Math.max(block.getWidth(), block.getHeight()),
                Math.min(block.getWidth(), block.getHeight()), block.getLength());
    }

    public Block getOriginalBlock() {
        return originalBlock;
    }

    public Block getFirstRotatedBlock() {
        return firstRotatedBlock;
    }

    public Block getSecondRotatedBlock() {
        return secondRotatedBlock;
    }
}