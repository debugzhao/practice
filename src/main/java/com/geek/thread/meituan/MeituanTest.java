//package com.geek.thread.meituan;
//
///**
// * @author lucas.zhao
// * @date 2023/09/19 18:37
// * @email jczhao_cs@163.com
// */
//
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//
//public class MeituanTest {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Service aService = new AService();
//        Service bService = new BService();
//        Service cService = new CService();
//
//        CompletableFuture<Integer> taskA = CompletableFuture.supplyAsync(aService::get);
//        CompletableFuture<Integer> taskB = CompletableFuture.supplyAsync(bService::get);
//        CompletableFuture<Integer> taskC = CompletableFuture.supplyAsync(cService::get);
//
//        // 完成所有任务，才可以进行下一步累加操作
//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(taskA, taskB, taskC);
//
//        // 等待所有任务执行完成
//        allFutures.join();
//
//        int total = 0;
//        // 累加三个任务的执行结果
//        total = taskA.get() + taskB.get() + taskC.get();
//        System.out.println("total: " + total);
//    }
//}
//
//interface Service {
//    int get();
//}
//
//class AService implements Service{
//    @Override
//    public int get() {
//        return 10;
//    }
//}
//
//class BService implements Service{
//    @Override
//    public int get() {
//        return 20;
//    }
//}
//
//class CService implements Service{
//    @Override
//    public int get() {
//        return 30;
//    }
//}
