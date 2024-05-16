package com.geek.basic.copy.shallow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhaojingchao
 * @Date 2024/05/17 01:48
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Cloneable{
    private String  name;

    @Override
    public Address clone() throws CloneNotSupportedException {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
