package com.anz.validations;

public interface NullEmptyCheck<T> {
    default boolean nullCheck(T t) {
        return null == t;
    }

    default boolean emptyCheck(T t) {
        if (!nullCheck(t) && t instanceof String) {
            return ((String) t).isEmpty();
        }
        return false;
    }
}