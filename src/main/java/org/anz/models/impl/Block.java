package org.anz.models.impl;

import org.anz.models.Shape;

public abstract class Block implements Shape {
    protected int area;

    public abstract int getWidth();

    public abstract int getLength();

    @Override
    public int area() {
        return area;
    }

}
