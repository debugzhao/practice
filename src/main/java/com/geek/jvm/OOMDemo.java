package com.geek.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucas.zhao
 * @date 2023/09/10 11:20
 * @email jczhao_cs@163.com
 */
public class OOMDemo {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
