package com.geek.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lucas.zhao
 * @date 2023/09/06 15:35
 * @email jczhao_cs@163.com
 * 等待通知机制实现两个线程交替打印奇数/偶数
 */
public class AlternatePrintingByCondition {

    public static void main(String[] args) throws InterruptedException {
        PrintRun printRun = new PrintRun();
        Thread thread1 = new Thread(printRun);
        Thread thread2 = new Thread(printRun);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + ": 两个子线程交替打印数字完毕");
    }

    public static class PrintRun implements Runnable{
        private final AtomicInteger count = new AtomicInteger(1); //也可替换成volatile
        private final Lock lock = new ReentrantLock();
        private final Condition single = lock.newCondition();
        private final Condition twin = lock.newCondition();

        @Override
        public void run(){
            lock.lock();
            try {
                while (count.get() <= 100){
                    if (count.get() % 2 == 1){
                        System.out.println(Thread.currentThread().getName()+"打印："+count.get());
                        twin.signal(); //不会真正唤醒twin，需要等待single释放锁
                        if (count.incrementAndGet() <= 100){
                            single.await(); //single等待并释放锁
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName()+"打印："+count.get());
                        single.signal();
                        if (count.incrementAndGet() <= 100){
                            twin.await();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
