package org.anz.models.impl;

import org.anz.models.Shape;

import java.util.Objects;

public class Cube extends Block implements Shape {
    private final int edge;


    public Cube(int edge) {
        this.edge = edge;
        this.area = edge * edge;
    }

    @Override
    public int getWidth() {
        return this.edge;
    }

    @Override
    public int getLength() {
        return this.edge;
    }

    @Override
    public int getHeight() {
        return edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;
        Cube cube = (Cube) o;
        return edge == cube.edge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(edge);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "edge=" + edge +
                '}';
    }
}
