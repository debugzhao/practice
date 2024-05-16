package com.geek.basic.copy.shallow;

/**
 * @Author zhaojingchao
 * @Date 2024/05/17 01:49
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(new Address("武汉"));
        Person person1 = person.clone();
        System.out.println(person1.getAddress() == person.getAddress());
        person.getAddress().setName("苏州");
        System.out.println(person1.getAddress().getName());
    }
}
