package com.xiaoming.day04;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/17 21:17
 * @Description: 生产者线程，添加度列
 */
class ProducerThread implements Runnable {
    public BlockingQueue<String> blockingQueue;
    /**
     * volatile保证可见性，禁止重排序
     */
    public volatile boolean flag = true;
    /**
     * 安全性的计数器
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println("###生产者线程已经启动###");
        try {
            while (flag) {
                //相当于 i++
                String data = atomicInteger.incrementAndGet() + "";

                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println("生产者存入队列成功！data：" + data);
                } else {
                    System.out.println("生产者存入队列失败！data：" + data);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者已经结束...");
        }

    }

    public void stop() {
        this.flag = false;
    }
}

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/17 21:30
 * @Description: 消费者队列，获取队列
 */
class ConsumerThread implements Runnable {
    public BlockingQueue<String> blockingQueue;
    /**
     * volatile保证可见性，禁止重排序
     */
    public volatile  boolean flag = true;

    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println("消费者线程已经启动...");
        try {
            while (flag) {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                //不需要判断 "",因为 "" 不会被阻塞
                if (data == null){
                    System.out.println("消费者超过2秒时间，没有获取到队列信息");
                    flag = false;
                    return;
                }
                System.out.println("消费者获取到data：" + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("消费者已经停止");
        }
    }
}


/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/17 21:16
 * @Description: 使用并发队列实现生产者与消费者
 */
public class Test003 {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(10);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
        Thread p1 = new Thread(producerThread);
        Thread c1 = new Thread(consumerThread);
        p1.start();
        c1.start();
        try {
            Thread.sleep( 1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producerThread.stop();
    }
}
