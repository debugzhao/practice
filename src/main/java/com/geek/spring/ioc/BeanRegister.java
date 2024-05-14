package com.geek.spring.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhaojingchao
 * @Date 2024/05/14 11:46
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class BeanRegister {

    //单例Bean缓存
    private Map<String, Object> singletonMap = new  HashMap<>(32);

    public Object getSingletonBean(String beanName) {
        return singletonMap.get(beanName);
    }

    public void registerSingletonBean(String beanName, Object bean) {
        if (singletonMap.containsKey(beanName)) {
            return;
        }
        singletonMap.put(beanName, bean);
    }

}
