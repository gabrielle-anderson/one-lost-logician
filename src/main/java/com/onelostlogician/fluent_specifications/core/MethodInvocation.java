package com.onelostlogician.fluent_specifications.core;

import com.onelostlogician.fluent_specifications.exceptions.MethodInterceptionException;

import java.lang.reflect.Method;
import java.util.UUID;

import static java.util.Objects.nonNull;

class MethodInvocation {
    public final Method method;
    public final Object[] args;
    public final UUID variableId;

    public MethodInvocation(Method method, Object[] args, UUID variableId) {
        nonNull(method);
        nonNull(args);
        nonNull(variableId);

        this.method = method;
        this.args = args;
        this.variableId = variableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodInvocation that = (MethodInvocation) o;

        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + hashCodeArray(args);
        result = 31 * result + variableId.hashCode();
        return result;
    }

    private static int hashCodeArray(Object a[]) {
        int result = 1;

        for (Object element : a) {
            int elementHashCode;
            try {
                elementHashCode = element.hashCode();
            }
            catch (MethodInterceptionException e) {
                elementHashCode = e.variableId.hashCode();
            }
            result = 31 * result + (element == null ? 0 : elementHashCode);
        }

        return result;
    }
}
