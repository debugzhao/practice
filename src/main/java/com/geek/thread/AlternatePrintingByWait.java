package com.geek.thread;

/**
 * @author lucas.zhao
 * @date 2023/09/06 15:35
 * @email jczhao_cs@163.com
 * 等待通知机制实现两个线程交替打印奇数/偶数
 */
public class AlternatePrintingByWait {
    private static final Object lock = new Object();
    private static int count = 1;
    private static final int max = 100;

    public static void main(String[] args) throws InterruptedException {
        // thread1打印奇数数字
        Thread thread1 = new Thread(() -> {
            while (count <= max) {
                synchronized (lock) {
                    if (count % 2 ==1) {
                        System.out.println(Thread.currentThread().getName() + ": " + count);
                        count ++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        // thread2 打印偶数数字
        Thread thread2 = new Thread(() -> {
            while (count <= max) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + count);
                        count ++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        // 启动两个子线程
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + ": 两个子线程交替打印数字完毕");
    }
}
