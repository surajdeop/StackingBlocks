package org.anz.models.impl;

import org.anz.models.Shape;

import java.util.Objects;

public class Cuboid extends Block implements Shape {
    private final int width;
    private final int length;
    private final int height;

    public Cuboid(int width, int length, int height) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.area = width * length;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cuboid)) return false;
        Cuboid cuboid = (Cuboid) o;
        return this.getWidth() == cuboid.getWidth() && this.getLength() == cuboid.getLength() && this.getHeight() == cuboid.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getWidth(), this.getLength(), this.getHeight());
    }

    @Override
    public String toString() {
        return "Cuboid{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
