package com.anz.models;

public class Block {
    private final int width;
    private final int length;
    private final int height;

    public Block(int... dimensions) {
        this.width = dimensions[0];
        this.length = dimensions[1];
        this.height = dimensions[2];
    }

    public int getWidth() {
        return width;
    }


    public int getLength() {
        return length;
    }


    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Block{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}