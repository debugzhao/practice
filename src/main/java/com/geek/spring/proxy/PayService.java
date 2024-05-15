package com.geek.spring.proxy;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 14:34
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public interface PayService {

    /**
     * 支付回调
     * @param outTradeNo 订单号
     * @return
     */
    String callback(String outTradeNo);

    /**
     * 下单
     * @param userId 用户id
     * @param productId 产品id
     * @return
     */
    int save(int userId,int productId);
}
