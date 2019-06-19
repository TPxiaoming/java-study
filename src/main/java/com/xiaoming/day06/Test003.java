package com.xiaoming.day06;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/19 22:49
 * @Description:    读写锁 类似于jvm 内存缓存
 */
public class Test003 {

    private volatile Map<String, String> cache = new HashMap<String, String>();

    /**
     * 读写锁
     */
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 写入锁
     */
    private WriteLock writeLock = rwl.writeLock();

    /**
     * 读取锁
     */
    private ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();

    /**
     * 写入元素
     * @param key
     * @param value
     */
    public void put(String key, String value){
        try {
            writeLock.lock();
            System.out.println("写入put方法，key：" + key + "，value：" + value + ". 开始");
            Thread.sleep(100);
            cache.put(key,value);
            System.out.println("写入put方法，key：" + key + "，value：" + value + ". 结束");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    /**
     * 读取元素
     * @param key
     */
    public String  get(String key){
        try {
            readLock.lock();
            System.out.println("读取 key：" + key + ". 开始");
            Thread.sleep(100);
            String value = cache.get(key);
            System.out.println("读取 key：" + key + ". 结束");
            return value;
        } catch (Exception e) {
            return null;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        final Test003 test003 = new Test003();
        //写进行
        Thread t1 = new Thread(new Runnable() {
            public void run() {

                for (int i = 0; i < 10; i++) {
                    test003.put(i + "", i + "");
                }
            }
        });


        //读进程
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    test003.get(i + "");
                }
            }
        });

        t1.start();
        t2.start();

    }

}
