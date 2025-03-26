package rut.miit.tech.springbeanprocessor.logging;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.InvocationHandler;
import rut.miit.tech.springbeanprocessor.annotations.LoggingMethod;

import java.lang.reflect.Method;

public class LoggingMethodInterceptor implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
