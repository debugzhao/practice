package com.geek.basic.copy.deep;

import com.geek.basic.copy.shallow.Address;
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
public class Person1 implements Cloneable{
    private Address address;

    @Override
    public Person1 clone() throws CloneNotSupportedException {
        try {
            Person1 person1 = (Person1) super.clone();
            person1.setAddress(person1.getAddress().clone());
            return person1;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
