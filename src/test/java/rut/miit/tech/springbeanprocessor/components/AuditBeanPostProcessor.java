package rut.miit.tech.springbeanprocessor.components;

import org.junit.jupiter.api.Order;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import rut.miit.tech.springbeanprocessor.interfaces.Auditable;
@Order(100)
@Component
public class AuditBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Auditable) {
            System.out.println("Обработка бина: " + beanName);
            return (Auditable) bean;
        }
        return bean;
    }
}