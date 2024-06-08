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
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map);
    }
}
