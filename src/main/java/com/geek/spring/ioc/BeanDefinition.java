package com.geek.spring.ioc;

import lombok.Data;

/**
 * @Author zhaojingchao
 * @Date 2024/05/14 11:43
 * @Email zhaojingchao@joysuch.com
 * @Desc 配置文件中bean对应的实体
 */
@Data
public class BeanDefinition {
    private String beanName;
    private Class beanClass;
}
