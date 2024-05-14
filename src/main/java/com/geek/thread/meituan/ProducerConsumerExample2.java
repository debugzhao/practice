package com.geek.thread.meituan;

import java.sql.Time;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lucas.zhao
 * @date 2023/09/22 13:56
 * @email jczhao_cs@163.com
 * 编写一个队列，生产者生产消息（消息内容是1,2,3,...,n），消费者消费消息，并将消息打印到控制台。
 * 要求：
 * 1.生产者以每秒10个的速率生产消息，队列满了后阻塞等待；
 * 2.队列长度为100；
 * 3.消费者以每秒1个的速率消费消息；
 * 生产者和消费者在不同的线程；
 */
public class ProducerConsumerExample2 {
    // 消息队列容量
    private static final int QUEUE_CAPACITY = 100;
    // 每秒10个消息
    private static final int PRODUCER_RATE = 10;
    // 每秒1个消息
    private static final int CONSUMER_RATE = 1;
    // 消费者数量
    private static final int CONSUMER_NUM = 20;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<AtomicInteger> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        Set<Integer> set = Collections.synchronizedSet(new HashSet<Integer>());
        ExecutorService threadPool = Executors.newFixedThreadPool(CONSUMER_NUM);
        AtomicInteger message = new AtomicInteger(0);


        // 生产者任务
        Thread producerThread = new Thread(() -> {
             while (true) {
                 // 将消息放入队列，如果队列已满则阻塞等待
                 try {
                     message.getAndIncrement();
                     queue.put(message);
                     System.out.println(Thread.currentThread().getName() + " 生产者生产消息：" + message.get());
                     TimeUnit.MILLISECONDS.sleep(1000 / PRODUCER_RATE);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
        }, "producer-thread");


        for (int i = 0; i < CONSUMER_NUM; i++) {
            threadPool.execute(() -> {
                while (true) {
                    // 从消息队列中取出消息，如果队列为空则阻塞
                    try {
                        int num = queue.take().get();
                        // 判断是否重复消费
                        if (!set.contains(num)) {
                            set.add(num);
                            System.out.println(Thread.currentThread().getName() + "----消费者消费消息----：" + num);
                        }
                        TimeUnit.MILLISECONDS.sleep(1000 / CONSUMER_RATE);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        producerThread.start();

        // 等待30后中断生产者线程、关闭线程池资源
        TimeUnit.SECONDS.sleep(30);
        producerThread.interrupt();
        threadPool.shutdown();
    }
}
