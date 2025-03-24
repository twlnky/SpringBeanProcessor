package rut.miit.tech.springbeanprocessor.logging;

import org.junit.jupiter.api.Order;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
@Order(200)
public class LoggingBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback((Callback) new LoggingMethodInterceptor(bean));
        return enhancer.create();
    }
}