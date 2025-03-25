package rut.miit.tech.springbeanprocessor.logging;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Order;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Callback;
import rut.miit.tech.springbeanprocessor.annotations.LoggingClass;

@Order(200)
public class LoggingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean,@NotNull String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(LoggingClass.class)) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback((Callback) new LoggingMethodInterceptor());
            return enhancer.create();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        return bean;
    }
}
