package com.geek.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lucas.zhao
 * @date 2023/09/06 12:54
 * @email jczhao_cs@163.com
 */
public class MyTask implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 执行子任务");
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.submit(new MyTask());
        threadPool.shutdown();
    }
}
