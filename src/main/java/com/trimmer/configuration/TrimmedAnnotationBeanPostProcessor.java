package com.trimmer.configuration;

import com.trimmer.annotations.Trimmed;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var beanType = bean.getClass();
        if (beanType.isAnnotationPresent(Trimmed.class)) {
            var enchancer = new Enhancer();
            enchancer.setSuperclass(beanType);
            MethodInterceptor methodInterceptor = (object, method, args, methodProxy) -> {
                for (int i=0; i<args.length; i++) {
                    if (args[i].getClass().isAssignableFrom(String.class)) args[i] = ((String)args[i]).trim();
                }
                var result = methodProxy.invokeSuper(object, args);
                if (result != null && result.getClass().isAssignableFrom(String.class)) result = ((String) result).trim();
                return result;
            };
            enchancer.setCallback(methodInterceptor);
            return enchancer.create();
        } else {
            return bean;
        }
    }
}
