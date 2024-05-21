package com.geek.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhaojingchao
 * @Date 2024/05/20 18:05
 * @Email zhaojingchao@joysuch.com
 * @Desc
 * https://juejin.cn/post/6844904195162636295
 * https://blog.csdn.net/Fire_Sky_Ho/article/details/114970345
 * https://www.cnblogs.com/FraserYu/p/13488703.html
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            System.out.println("电饭煲开始做饭");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "白米饭";
        }).thenAccept(result -> {
            System.out.println("开始吃米饭");
        });

        System.out.println("我先去搞点牛奶和鸡蛋");
        future.join();
    }
}
