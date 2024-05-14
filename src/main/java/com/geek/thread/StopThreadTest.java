package com.geek.thread;

import java.util.Date;

/**
 * @author lucas.zhao
 * @date 2023/09/06 16:10
 * @email jczhao_cs@163.com
 */
public class StopThreadTest extends Thread{

    // 退出标志位
    public volatile boolean flag = false;

    @Override
    public void run() {
        while (!flag) {
            System.out.println("子线程正在执行...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date());
        StopThreadTest stopThreadTest = new StopThreadTest();
        stopThreadTest.start();

        // 主线程睡6s之后使子线程退出
        Thread.sleep(6000);
        stopThreadTest.flag = true;
        System.out.println(new Date());
    }
}
