package com.geek.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lucas.zhao
 * @date 2023/09/14 22:59
 * @email jczhao_cs@163.com
 * https://juejin.cn/post/6977549754217529358?searchId=2023091422445815D7D0872F82E464DA93#comment
 * 模拟业务场景：五个人约饭店吃饭（每个人到达的时间不一样），等五个人都到达饭店（屏障点）之后再分别开始点餐
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + "： 大家都到齐了，开始点餐吧~");
        });

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                int duration = new Random().nextInt(4) + 1;
                String name = Thread.currentThread().getName();
                try {
                    // 不同线程执行任务耗时不一样
                    TimeUnit.SECONDS.sleep(duration);
                    System.out.println(name + ": 耗时" + duration + "s");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name + ": 开始点餐啦~");
            });
        }

        executorService.shutdown();
    }
}
