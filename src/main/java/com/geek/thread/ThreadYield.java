package com.geek.thread;

/**
 * @Author zhaojingchao
 * @Date 2024/05/20 18:01
 * @Email zhaojingchao@joysuch.com
 * @Desc  https://blog.csdn.net/MinggeQingchun/article/details/127264243
 */
public class ThreadYield {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i < 1000;i++){
                    System.out.println(Thread.currentThread().getName() + "---->" + i);
                }
            }
        });
        t.setName("t");
        t.start();

        for (int i = 1;i < 1000;i++){
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}
