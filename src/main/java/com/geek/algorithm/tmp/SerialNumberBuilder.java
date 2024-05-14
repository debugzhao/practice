package com.geek.algorithm.tmp;

/**
 * @author lucas.zhao
 * @date 2023/10/09 15:26
 * @email jczhao_cs@163.com
 */
public class SerialNumberBuilder {
    private static volatile SerialNumberBuilder instance;

    private int serialNumber;

    private SerialNumberBuilder(){
        serialNumber = 0;
    }

    public static SerialNumberBuilder getInstance(){
        if (instance == null){
            synchronized (SerialNumberBuilder.class){
                if (instance == null){
                    instance = new SerialNumberBuilder();
                }
            }
        }
        return instance;
    }

    public synchronized int getNextSerialNumber() {
        return ++serialNumber;
    }
}
