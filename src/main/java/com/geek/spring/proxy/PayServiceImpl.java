package com.geek.spring.proxy;

/**
 * @Author zhaojingchao
 * @Date 2024/05/15 14:35
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class PayServiceImpl implements PayService{
    @Override
    public String callback(String outTradeNo) {
        System.out.println("目标类 PayServiceImpl 回调 方法 callback");
        return outTradeNo;
    }

    @Override
    public int save(int userId, int productId) {
        System.out.println("目标类 PayServiceImpl方法 save");
        return productId;
    }
}
