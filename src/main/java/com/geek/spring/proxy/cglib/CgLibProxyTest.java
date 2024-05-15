package com.geek.spring.proxy.cglib;

import com.geek.spring.proxy.PayService;
import com.geek.spring.proxy.PayServiceImpl;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 15:13
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class CgLibProxyTest {
    public static void main(String[] args) {
        CgLibProxy cgLibProxy = new CgLibProxy();
        PayService payService = (PayService)cgLibProxy.newProxyInstance(new PayServiceImpl());
        String callback = payService.callback("callback");
        System.out.println(callback);
    }
}
