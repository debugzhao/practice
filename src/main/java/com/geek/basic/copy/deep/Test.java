package com.geek.basic.copy.deep;

import com.geek.basic.copy.shallow.Address;
import com.geek.basic.copy.shallow.Person;

/**
 * @Author zhaojingchao
 * @Date 2024/05/17 01:59
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person1 person = new Person1(new Address("武汉"));
        Person1 person1 = person.clone();
        System.out.println(person1.getAddress() == person.getAddress());
    }
}
