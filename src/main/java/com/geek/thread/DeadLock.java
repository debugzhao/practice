package com.geek.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author lucas.zhao
 * @date 2023/09/07 10:44
 * @email jczhao_cs@163.com
 * 模拟死锁：多个线程争抢资源而造成互相等待情况
 */
public class DeadLock {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "：持有A锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "：等待获取B锁");
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "：持有B锁");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread() + "：持有B锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "：等待获取A锁");
                synchronized (lockA) {
                    System.out.println(Thread.currentThread() + "：持有A锁");
                }
            }
        }, "线程 2").start();

    }
}
