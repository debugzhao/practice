package com.geek.spring.proxy.jdk;

import com.geek.spring.proxy.PayService;
import com.geek.spring.proxy.PayServiceImpl;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 14:57
 * @Email zhaojingchao@joysuch.com
 * @Desc JDK动态代理测试
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        // JDK动态代理
        JDKProxy jdkProxy = new JDKProxy();
        // 获取动态代理对象
        PayService payService = (PayService)jdkProxy.newProxyInstance(new PayServiceImpl());
        int save = payService.save(1, 2);
        String callback = payService.callback("123");
    }
}
