package com.geek.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lucas.zhao
 * @date 2023/09/08 20:11
 * @email jczhao_cs@163.com
 * https://www.cnblogs.com/hapjin/p/10898451.html
 */
public class ExecutorCompletionServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executorCompletionTest();
        // futureTest();
    }

    static void executorCompletionTest() throws InterruptedException, ExecutionException {
        Random random = new Random();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(threadPool);

        for (int i = 0; i < 20; i++) {
            completionService.submit(() -> {
                // 模拟任务耗时情况
                int time = random.nextInt(3);
                TimeUnit.SECONDS.sleep(time + 1);
                return Thread.currentThread().getName() + ": "+ (time + 1);
            });
        }

        TimeUnit.SECONDS.sleep(2);

        System.out.println("handle result begin");
        long startTime = System.currentTimeMillis();
        int completionTask = 0;
        while(completionTask < 20) {
            //如果完成队列中没有数据, 则阻塞; 否则返回队列中的数据
            // Future<String> resultHolder = completionService.take();
            Future<String> task = completionService.poll();
            if (task == null) {
                System.out.println("当前任务尚未结束");
            } else {
                System.out.println("result: " + task.get());
            }
            completionTask++;
        }

        System.out.println(completionTask + " task done !");
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));

        //ExecutorService使用完一定要关闭 (回收资源, 否则系统资源耗尽)
        threadPool.shutdown();
    }

    static void futureTest() throws ExecutionException, InterruptedException {
        Random random = new Random();
        List<Future<String>> taskList = new ArrayList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 20; i++) {
            Future<String> task = threadPool.submit(() -> {
                // 模拟任务耗时情况
                int time = random.nextInt(3);
                TimeUnit.SECONDS.sleep(time + 1);
                return Thread.currentThread().getName() + ": "+ (time + 1);
            });
            // 收集任务结果
            taskList.add(task);
        }

        System.out.println("handle result begin");
        long startTime = System.currentTimeMillis();
        int count = 0;
        // 获取任务执行结果
        for (Future<String> task : taskList) {
            System.out.println(task.get());
            count ++;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("handle result end");
        System.out.println(count + " task done !");
        System.out.println("耗时：" + (endTime - startTime));

        threadPool.shutdown();
    }
}
