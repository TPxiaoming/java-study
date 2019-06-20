package com.xiaoming.day06;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/20 21:40
 * @Description:    乐观锁 两个线程，同时操作一个全局变量，演示线程安全问题
 */
public class Test005 implements Runnable{
    /**
     * 线程安全
     */
    AtomicInteger count = new AtomicInteger();

    public void run() {
        while (true) {
            Integer count = getCount();
            if (count >= 170){
                break;
            }
            System.out.println(count);
        }
    }

    public  Integer getCount() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //每次自增 i++ 线程安全，底层没有使用锁
        return count.incrementAndGet();
    }

    public static void main(String[] args) {
        Test005 test005 = new Test005();
        Thread t1 = new Thread(test005);
        Thread t2 = new Thread(test005);
        t1.start();
        t2.start();
    }
}
