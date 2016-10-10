package com.onelostlogician.subclassing_builders;

public abstract class BaseClass {
    protected Integer field1;

    BaseClass() {}

    public Integer getField1() {
        return field1;
    }

    public abstract static class Builder<T extends BaseClass, BU extends BaseClass.Builder> {
        protected T obj;

        protected Builder(T obj) {
            this.obj = obj;
        }

        protected final BU getThis() {
            return (BU) this;
        }

        public BU withField1(Integer field1) {
            obj.field1 = field1;
            return getThis();
        }

        public T build() { return this.obj; }
    }
}