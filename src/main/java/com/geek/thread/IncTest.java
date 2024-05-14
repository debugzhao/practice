package com.geek.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lucas.zhao
 * @date 2023/09/07 09:44
 * @email jczhao_cs@163.com
 * 多线程操作共享变量，期望输出的结果是0，实际每次输出的结果都不一致
 */
public class IncTest {

    // count++ 操作不是原子操作。通过javap反编译可以知道底层分为三个步骤实现自增
    // volatile只能保证共享变量的可见性，不能保证共享变量操作的原子性
    // 所以只用volatile修饰共享变量还是会出现线程安全问题
    private static volatile int count = 0;
    private static AtomicInteger integer = new AtomicInteger(0);

    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        incBySynchronized();
    }

    private static void incBySynchronized() throws InterruptedException {
        Object lock = new Object();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    num ++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    num --;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("共享变量num结果是：" + num);
    }

    private static void incByLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    lock.lock();
                    num ++;
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    lock.lock();
                    num --;
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("共享变量num结果是：" + num);
    }

    private void incByAtomic() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                integer.getAndIncrement();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                integer.getAndDecrement();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("共享变量count结果是：" + integer.get());
    }
}
