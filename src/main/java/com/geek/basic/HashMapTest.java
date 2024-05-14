package com.geek.basic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lucas.zhao
 * @date 2023/10/17 19:10
 * @email jczhao_cs@163.com
 */
public class HashMapTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Integer[] array = {1, 2, 3};
        String[] stringArray = {"a", "b", "c"};
        print(array);
        print(stringArray);
    }

    public static int test() {
        int i = 0;
        try {
            i = 2;
            return i;
        } finally {
            i = 3;
        }
    }


    /**
     * 泛型方法
     * @param array
     * @param <E>
     */
    public static <E> void print(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }

    void cloneTest() {
        Student student1 = new Student("lucas", 20);
        // Student clone = (Student) student1.clone();
        Student clone = student1;
        System.out.println(student1 == clone);
        clone.setAge(100);
        System.out.println("clone age:" + clone.getAge());
        System.out.println("student1 age:" + student1.getAge());
    }
}



@Data
@AllArgsConstructor
class Student implements Cloneable{
    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}



