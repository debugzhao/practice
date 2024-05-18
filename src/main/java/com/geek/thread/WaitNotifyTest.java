package com.geek.thread;

import net.sf.jsqlparser.statement.select.Wait;

import javax.swing.plaf.TableHeaderUI;

/**
 * @Author zhaojingchao
 * @Date 2024/05/17 14:19
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class WaitNotifyTest {
    private static Object lock = new Object();

    static class WaitThread extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "初次获得锁，开始调用wait方法");
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "再次获得锁，继续执行");
            }
        }
    }

    static class NotifyThread extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                lock.notify();
                System.out.println(Thread.currentThread().getName() + "获得锁，执行了notify方法");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.setName("waitThread");
        waitThread.start();
//         waitThread.run();
//        Thread.sleep(1000);
//        NotifyThread notifyThread = new NotifyThread();
//        notifyThread.setName("notifyThread");
//        notifyThread.start();
    }
}
