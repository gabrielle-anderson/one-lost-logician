package com.onelostlogician.subclassing_builders;

public final class SubSubClass extends SubClass {
    protected String field3 = null;

    SubSubClass() {}

    public String getField3() {
        return field3;
    }

    public static <BU extends SubSubClass.Builder<SubSubClass, BU>> SubSubClass.Builder<SubSubClass,BU> newSubSubClassBuilder() {
        return new SubSubClass.Builder<>(new SubSubClass());
    }

    public static class Builder<T extends SubSubClass, BU extends SubSubClass.Builder<T, BU>> extends SubClass.Builder<T, BU> {

        protected Builder(T obj) {
            super(obj);
        }

        public BU withField3(String field3) {
            obj.field3 = field3;
            return getThis();
        }

        public T build() { return this.obj; }
    }
}