package com.geek.spring.proxy.static1;

import com.geek.spring.proxy.PayService;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 14:35
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class StaticProxyPayServiceImpl implements PayService {

    private PayService payService;
    public StaticProxyPayServiceImpl(PayService payService) {
        this.payService=payService;
    }

    @Override
    public String callback(String outTradeNo) {
        System.out.println("StaticProxyPayServiceImpl callback begin");
        String result=payService.callback(outTradeNo);
        System.out.println("StaticProxyPayServiceImpl callback end");
        return result;
    }

    @Override
    public int save(int userId, int productId) {
        System.out.println("StaticProxyPayServiceImpl save begin");
        int id = payService.save(userId, productId);
        System.out.println("StaticProxyPayServiceImpl save end");
        return id;
    }
}
