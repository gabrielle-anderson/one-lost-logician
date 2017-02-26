package com.onelostlogician.fluent_specifications.proxy;

import com.onelostlogician.fluent_specifications.exceptions.MethodInterceptionException;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.UUID;

public class CGLibMethodInterceptor implements MethodInterceptor {
    private final UUID variableId;

    public CGLibMethodInterceptor(UUID variableId) {
        this.variableId = variableId;
    }

    public Object intercept(Object object, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {

        throw new MethodInterceptionException(method, args, methodProxy, variableId);
//        return methodProxy.invokeSuper(object, args);
    }
}
