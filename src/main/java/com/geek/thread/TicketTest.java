package com.geek.thread;

/**
 * @author lucas.zhao
 * @date 2023/09/06 19:26
 * @email jczhao_cs@163.com
 */
public class TicketTest {
    Object lock = new Object();
    // 车票数量
    int ticketNum = 10;

    public void sellTicket() {
        synchronized (lock) {
            if (ticketNum <= 0) {
                return;
            }
            // 非原子操作
            ticketNum --;
            System.out.println(Thread.currentThread().getName() + "抢到了一张票，剩余：" + ticketNum);
        }
    }

    public static void main(String[] args) {
        TicketTest ticketTest = new TicketTest();

        // 开启20个线程同时抢10张票
        for (int i = 0; i < 20; i++) {
            new Thread(ticketTest::sellTicket).start();
        }
    }
}
