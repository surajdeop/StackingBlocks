package org.anz.compares;

import org.anz.models.Shape;

public interface Subset<T extends Shape> {
    boolean isSubset(T shape, T nextShape);
}
