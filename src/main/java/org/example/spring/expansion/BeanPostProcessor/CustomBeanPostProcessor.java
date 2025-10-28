package org.example.spring.expansion.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自定义bean后处理器
 *
 * @author puying
 * @date 2025/10/28
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean.getClass().isAnnotationPresent(InterfacePerformanceMonitor.class)
                ? Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InterfacePerformanceMonitorInvocationHandler(bean))
                : bean;
    }

    /**
     * 接口性能监视器调用处理程序
     *
     * @author puying
     * @date 2025/10/28
     */
    private static class InterfacePerformanceMonitorInvocationHandler implements InvocationHandler {
        private final Object target;

        public InterfacePerformanceMonitorInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                // Object方法直接调用invoke, 不做代码增强
                return method.invoke(target, args);
            }

            long st = System.currentTimeMillis();
            try {
                Object result = method.invoke(target, args);
                long et = System.currentTimeMillis();
                //log.info("方法[{}] 执行耗时:{}ms", method.getName(), et - st);
                return result;
            } catch (Exception e) {
                long et = System.currentTimeMillis();
                //log.error("方法[{}] 执行异常, 耗时:{}ms, 异常信息:{}", method.getName(), et - st, e.getMessage(), e);
                throw e;
            }
        }
    }
}
