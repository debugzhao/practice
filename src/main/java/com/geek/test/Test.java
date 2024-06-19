package com.geek.test;

/**
 * @Author zhaojingchao
 * @Date 2024/06/18 10:40
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class Test{
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static String test() {
        String res = "";
        try {
            int a = 1, b = 0, c;
            c = a/b;
            res = "1";
            return res;
        }catch (Exception e) {
            System.out.print(res);
            e.printStackTrace();
            res = "2";
            return res;
        } finally {
            System.out.println(res);
            res = "3";
            return res;
        }
    }
}
