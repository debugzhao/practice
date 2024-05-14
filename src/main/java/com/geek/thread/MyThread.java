package com.geek.thread;

/**
 * @author lucas.zhao
 * @date 2023/09/06 12:44
 * @email jczhao_cs@163.com
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
