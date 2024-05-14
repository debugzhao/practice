package com.geek.thread;

/**
 * @author lucas.zhao
 * @date 2023/09/09 16:05
 * @email jczhao_cs@163.com
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
//        new Thread(() -> {
//            String name = Thread.currentThread().getName();
//            threadLocal.set("拖延");
//            print(name);
//            System.out.println(name + " after remove: " + threadLocal.get());
//        }, "t1").start();
//
//        new Thread(() -> {
//            String name = Thread.currentThread().getName();
//            threadLocal.set("强迫症");
//            print(name);
//            System.out.println(name + " after remove: " + threadLocal.get());
//        }, "t2").start();
        new Service1().process("赵静超");
    }

    static void print(String threadName) {
        // 获取当前线程在本地内存中的值
        System.out.println(threadName + ": " + threadLocal.get());
        // 清除当前线程本地内存中的变量
        threadLocal.remove();
    }

}

class Service1 {
    public void process(String name) {
        User user = new User(name);
        UserContext.context.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContext.context.get();
        System.out.println("Service2: " + user.getName());
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContext.context.get();
        System.out.println("Service3: " + user.getName());
        UserContext.context.remove();
    }
}


class UserContext {
    static ThreadLocal<User> context = new ThreadLocal<>();
}


class User {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

}
