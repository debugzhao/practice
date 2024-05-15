package com.geek.spring.proxy.static1;

import com.geek.spring.proxy.PayService;
import com.geek.spring.proxy.PayServiceImpl;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 14:37
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class ProxyTest {
    public static void main(String[] args) {
        PayService payService = new StaticProxyPayServiceImpl(new PayServiceImpl());
        payService.save(1, 2);
        payService.callback("jffj34567");
    }
}
