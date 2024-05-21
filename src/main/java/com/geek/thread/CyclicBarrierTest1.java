package com.geek.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhaojingchao
 * @Date 2024/05/21 10:47
 * @Email zhaojingchao@joysuch.com
 * @Desc
 * https://www.jianshu.com/p/4ef4bbf01811
 */
public class CyclicBarrierTest1 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new GuideTask());

        int nums = Runtime.getRuntime().availableProcessors();
        System.out.println("核心数量：" + nums);

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                nums + 1,
                2 * nums,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        CompletionService<Void> completionService = new ExecutorCompletionService<>(threadPool);
        completionService.submit(new TravelTask(cyclicBarrier, "哈登", 5), null);
        completionService.submit(new TravelTask(cyclicBarrier, "保罗", 3), null);
        completionService.submit(new TravelTask(cyclicBarrier, "拜登", 2), null);
        threadPool.shutdown();
    }

    /**
     * 旅行者线程
     */
    static class TravelTask implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private String name;
        // 到达时间
        private int arriveTime;

        public TravelTask(CyclicBarrier cyclicBarrier, String name, int arriveTime) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
            this.arriveTime = arriveTime;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(arriveTime);
                System.out.println(name + "到达集合点");
                // 屏障点
                cyclicBarrier.await();
                System.out.println(name + "出发");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 导游线程
     */
    static class GuideTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("导游开始发护照");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("导游开始办理签证");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
