package com.geek.thread;

/**
 * @author lucas.zhao
 * @date 2023/09/06 15:50
 * @email jczhao_cs@163.com
 */
public class AlternatePrintingByYield {
    private static final Object lock = new Object();
    private static int count = 1;
    private static final int max = 100;

    public static void main(String[] args) throws InterruptedException {
        // thread1 打印奇数数字
        Thread thread1 = new Thread(() -> {
            while (count < max) {
                synchronized (lock) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + count);
                        count ++;
                    }
                }
                Thread.yield();
            }
        });

        // thread2 打印偶数数字
        Thread thread2 = new Thread(() -> {
            while (count < max) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                         System.out.println(Thread.currentThread().getName() + ": " + count);
                        count ++;
                    }
                }
                Thread.yield();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + ": 两个子线程交替打印数字完毕");
    }
}
