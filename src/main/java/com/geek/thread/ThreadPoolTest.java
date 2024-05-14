package com.geek.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lucas.zhao
 * @date 2023/09/08 19:31
 * @email jczhao_cs@163.com
 */
public class ThreadPoolTest {

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run...");
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new Task());
        }
        threadPool.shutdown();
    }
}
