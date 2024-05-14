package com.geek.algorithm.temp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.concurrent.*;

/**
 * @author lucas.zhao
 * @date 2023/10/10 20:02
 * @email jczhao_cs@163.com
 *
 *
 */
public class LongPrefixString {
    public static void main(String[] args) {

        // 创建定时任务线程池
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        threadPool.scheduleAtFixedRate(new Task(),0,2, TimeUnit.SECONDS);
        // 关闭线程池资源
        threadPool.shutdown();
    }

    static void json2String() {
        String json = "{\n" +
                "    \"l1\": {\n" +
                "        \"l1_1\": [\n" +
                "            \"l1_1_1\",\n" +
                "            \"l1_1_2\"\n" +
                "        ],\n" +
                "        \"l1_2\": {\n" +
                "            \"l1_2_1\": 121\n" +
                "        }\n" +
                "    },\n" +
                "    \"l2\": {\n" +
                "        \"l2_1\": null,\n" +
                "        \"l2_2\": true,\n" +
                "        \"l2_3\": {}\n" +
                "    }\n" +
                "}";
        Object o = JSON.toJSON(json);
        System.out.println(o);
    }

}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("定时任务");
    }
}

