package org.example.spring.expansion.BeanPostProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口性能监视器（仅接口使用, 这里会采用JDK动态代理实现监控)
 *
 * @author puying
 * @date 2025/10/27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfacePerformanceMonitor {
    /**
     * 限流控制(每秒执行最大次数)
     *
     * @return int
     */
    int limit() default 1000;
}
