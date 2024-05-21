package com.geek.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Author zhaojingchao
 * @Date 2024/05/21 09:36
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();


        Semaphore semaphore = new Semaphore(2);
        MyRunnable myRunnable = new MyRunnable(semaphore);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {
        // 成员属性 Semaphore对象
        private final Semaphore semaphore;

        public MyRunnable(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            // 获取许可
            boolean acquire = semaphore.tryAcquire();
            // 未获取到许可 结束
            if (!acquire) {
                System.out.println("线程【" + threadName + "】未获取到许可，结束");
                return;
            }
            // 获取到许可
            try {
                System.out.println("线程【" + threadName + "】获取到许可");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放许可
                semaphore.release();
                System.out.println("线程【" + threadName + "】释放许可");
            }
        }
    }
}


