package com.geek.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhaojingchao
 * @Date 2024/05/20 18:41
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<Integer>> callables = Arrays.asList(
                ()->{
                    mySleep(20);
                    System.out.println("=============20 end==============");
                    return 20;
                },
                ()->{
                    mySleep(10);
                    System.out.println("=============10 end==============");
                    return 10;
                }
        );

        List<Future<Integer>> futures = new ArrayList<>();
        //提交任务,并将future添加到list集合中
        futures.add(executorService.submit(callables.get(0)));
        futures.add(executorService.submit(callables.get(1)));
        //遍历Future,因为不知道哪个任务先完成,所以这边模拟第一个拿到的就是执行时间最长的任务,那么执行时间较短的任务就必须等待执行时间长的任务执行完
        for (Future future:futures) {
            System.out.println("结果: "+future.get());
        }
        System.out.println("============main end=============");
    }
    private static void mySleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
