package com.onelostlogician.fluent_specifications.exceptions;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

public class MethodInterceptionException extends RuntimeException {
    public final Method method;
    public final Object[] args;
    public final MethodProxy methodProxy;
    public final UUID variableId;

    public MethodInterceptionException(Method method, Object[] args, MethodProxy methodProxy, UUID variableId) {
        this.method = method;
        this.args = args;
        this.methodProxy = methodProxy;
        this.variableId = variableId;
    }

    @Override
    public String toString() {
        return "MethodInterceptionException{" +
                "method=" + method +
                ", args=" + Arrays.toString(args) +
                ", methodProxy=" + methodProxy +
                ", variableId=" + variableId +
                '}';
    }
}
