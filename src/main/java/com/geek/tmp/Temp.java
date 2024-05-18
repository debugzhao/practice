package com.geek.tmp;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Objects;

/**
 * @Author zhaojingchao
 * @Date 2024/04/28 16:19
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */

public class Temp {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("1");
        strings.add("2");
        System.out.println(strings);
    }
}
