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
public class Person implements Cloneable{
    private Address address;

    @Override
    public Person clone() throws CloneNotSupportedException {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
