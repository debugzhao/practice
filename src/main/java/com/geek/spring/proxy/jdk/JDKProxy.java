package com.geek.spring.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 14:50
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@Slf4j
public class JDKProxy implements InvocationHandler {

    // 目标类
    private Object targetObject;

    /**
     * 获取代理对象
     * @param targetObject 目标类
     * @return
     */
    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        try {
            log.info("JDK动态代理- 方法名：{}", method.getName());
            log.info("JDK动态代理- 入参：{}", args);
            result = method.invoke(targetObject, args);
            log.info("JDK动态代理- 出参：{}", result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
