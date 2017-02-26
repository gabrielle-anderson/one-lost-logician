package com.onelostlogician.fluent_specifications.core;

import com.onelostlogician.fluent_specifications.proxy.CGLibProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.fest.assertions.api.Assertions.assertThat;

public class MethodInvocationTest {
    @Test
    public void shouldMapNormalArguments() {
        Map<MethodInvocation, Boolean> methodMap = new HashMap<>();
        Class proxied = Integer.class;
        Method[] declaredMethods = proxied.getDeclaredMethods();
        assertThat(declaredMethods.length).isPositive();
        Method declaredMethod = declaredMethods[0];
        Object[] args = new Object[1];
        args[0] = 1;
        UUID variableId = randomUUID();
        boolean value = true;
        MethodInvocation key = new MethodInvocation(declaredMethod, args, variableId);

        methodMap.put(key, value);

        assertThat(methodMap.get(key)).isEqualTo(value);
    }

    @Test
    public void shouldMapProxiedArguments() {
        Map<MethodInvocation, Boolean> methodMap = new HashMap<>();
        Class invokeeClass = Integer.class;
        UUID invokeeVariableId = randomUUID();
        Method[] invokeeMethods = invokeeClass.getDeclaredMethods();
        assertThat(invokeeMethods.length).isPositive();
        Method invokeeMethod = invokeeMethods[0];

        Object[] args = new Object[1];
        UUID argVariableId = randomUUID();
        Class argClass = EmptyInterface.class;
        args[0] = CGLibProxy.createCGLibProxy(argClass, argVariableId);

        MethodInvocation key = new MethodInvocation(invokeeMethod, args, invokeeVariableId);
        boolean value = true;

        methodMap.put(key, value);

        assertThat(methodMap.get(key)).isEqualTo(value);
    }

    @Test
    public void shouldHashProxiedArguments() {
        Class invokeeClass = Integer.class;
        UUID invokeeVariableId = randomUUID();
        Method[] invokeeMethods = invokeeClass.getDeclaredMethods();
        assertThat(invokeeMethods.length).isPositive();
        Method invokeeMethod = invokeeMethods[0];

        Object[] args = new Object[1];
        UUID argVariableId = randomUUID();
        Class argClass = EmptyInterface.class;
        args[0] = CGLibProxy.createCGLibProxy(argClass, argVariableId);

        MethodInvocation methodInvocation = new MethodInvocation(invokeeMethod, args, invokeeVariableId);

        Object[] variableAsArg = new Object[1];
        variableAsArg[0] = argVariableId;
        MethodInvocation invocationWithVariableAsArg = new MethodInvocation(invokeeMethod, args, invokeeVariableId);

        assertThat(methodInvocation.hashCode()).isEqualTo(invocationWithVariableAsArg.hashCode());
    }
}