package com.onelostlogician.subclassing_builders;

import java.util.UUID;

public class SubClass extends BaseClass {
    protected UUID field2 = null;

    SubClass() {}

    public UUID getField2() {
        return field2;
    }

    public static <BU extends SubClass.Builder<SubClass, BU>> SubClass.Builder<SubClass,BU> newSubClassBuilder() {
        return new SubClass.Builder<>(new SubClass());
    }

    public static class Builder<T extends SubClass, BU extends SubClass.Builder> extends BaseClass.Builder<T, BU> {

        protected Builder(T obj) { super(obj); }

        public BU withField2(UUID field2) {
            obj.field2 = field2;
            return getThis();
        }

        public T build() { return this.obj; }
    }
}