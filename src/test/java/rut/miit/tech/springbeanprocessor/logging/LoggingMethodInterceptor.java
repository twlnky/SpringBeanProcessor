package rut.miit.tech.springbeanprocessor.logging;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import rut.miit.tech.springbeanprocessor.annotations.LoggingMethod;

public class LoggingMethodInterceptor implements MethodInterceptor {




    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            if (invocation.getMethod().getAnnotation(LoggingMethod.class) != null) {
                LoggingMethod loggingMethod = invocation.getMethod().getAnnotation(LoggingMethod.class);
                System.out.println(loggingMethod);
            }
            return invocation.proceed();
        } catch (Throwable e) {
            throw new RuntimeException("Invocation failed "+e);
        }
    }
}
