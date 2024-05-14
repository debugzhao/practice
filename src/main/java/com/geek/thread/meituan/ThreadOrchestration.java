package com.geek.thread.meituan;

import java.util.concurrent.*;

/**
 * @author lucas.zhao
 * @date 2023/09/22 15:28
 * @email jczhao_cs@163.com
 * 使用CompletableFuture进行线程编排
 */
public class ThreadOrchestration {

    // 手动创建线程池效果会更好
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(
            3,
            6,
            3,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        int result = calculateResult();
        System.out.println("Final Result: " + result);

        // 关闭线程池
        executorService.shutdown();
    }

    public static int calculateResult() {
        CompletableFuture<Integer> taskA = CompletableFuture.supplyAsync(AService::get, executorService);
        CompletableFuture<Integer> taskB = CompletableFuture.supplyAsync(BService::get, executorService);

        CompletableFuture<Integer> combinedFuture = taskA.thenCombine(taskB, (a, b) -> a + b)
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> CService.get(result), executorService));

        try {
            int finalResult = combinedFuture.get();
            return finalResult * 100;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return 0;
        }
    }
}


class AService {
    public static int get() {
        return 10;
    }
}

class BService {
    public static int get() {
        return 20;
    }
}

class CService {
    public static int get(int num) {
        return num;
    }
}
