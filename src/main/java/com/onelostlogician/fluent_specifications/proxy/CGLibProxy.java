package com.onelostlogician.fluent_specifications.proxy;

import com.onelostlogician.fluent_specifications.IRobot;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.joining;

public class CGLibProxy {
    public static <T> T createCGLibProxy(Class<T> tClass, UUID variableId) {
        return (T) Enhancer.create(tClass, new CGLibMethodInterceptor(variableId));
    }

    public static <T> T createProxy(Class<T> clazz) {
        Object proxyInstance = Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                (proxy, method, args) -> {
                    String method_name = method.getName();

                    StringBuilder builder = new StringBuilder();
                    builder.append(method_name);
                    builder.append("(");
                    List<String> arguments = new ArrayList<>();
                    for (int i = 0; i < method.getParameterCount(); i++) {
                        arguments.add(method.getParameterTypes()[i].getCanonicalName() + ": " + args[i].toString());
                    }

                    builder.append(arguments.stream().collect(joining(", ")));
                    builder.append(")");
                    System.out.println(builder.toString());
                    return null;
                });
        return (T) proxyInstance;
    }

    public static IRobot createIRobot2() {
        Object proxyInstance = getObject(IRobot.class);
        return (IRobot) proxyInstance;
    }

    public static <T> T createIRobot3(Class<T> clazz) {
        Object proxyInstance = getObject(IRobot.class);
        return (T) proxyInstance;
    }

    private static Object getObject(Class<IRobot> aClass) {
        return Proxy.newProxyInstance(
                aClass.getClassLoader(),
                new Class[]{aClass},
                (proxy, method, args) -> {
                    String method_name = method.getName();

                    StringBuilder builder = new StringBuilder();
                    builder.append(method_name);
                    builder.append("(");
                    List<String> arguments = new ArrayList<>();
                    for (int i = 0; i < method.getParameterCount(); i++) {
                        arguments.add(method.getParameterTypes()[i].getCanonicalName() + ": " + args[i].toString());
                    }

                    builder.append(arguments.stream().collect(joining(", ")));
                    builder.append(")");
                    System.out.println(builder.toString());
                    return null;
                });
    }
}
