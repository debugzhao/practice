package com.geek.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhaojingchao
 * @Date 2024/05/20 18:38`
 * @Email zhaojingchao@joysuch.com
 * @Desc https://blog.csdn.net/liuyu973971883/article/details/108055564
 */
public class CompletionServiceExample {
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

        //构建ExecutorCompletionService,与线程池关联
        CompletionService completionService = new ExecutorCompletionService(executorService);
        //提交Callable任务
        completionService.submit(callables.get(0));
        completionService.submit(callables.get(1));
        //获取future结果,不会阻塞
        Future<Integer> pollFuture = completionService.poll();
        //这里因为没有执行完成的Callable,所以返回null
        System.out.println(pollFuture);
        //获取future结果,最多等待3秒,不会阻塞
        Future<Integer> pollTimeOutFuture = completionService.poll(3,TimeUnit.SECONDS);
        //这里因为没有执行完成的Callable,所以返回null
        System.out.println(pollTimeOutFuture);
        //通过take获取Future结果,此方法会阻塞
        for(int i=0;i<callables.size();i++){
            System.out.println(completionService.take().get());
        }

        System.out.println("============main end=============");
        executorService.shutdown();
    }
    private static void mySleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
