package com.xiaoming.day04;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class TaskThread implements Runnable {
    private String threadName;

    public TaskThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "," + threadName);
    }
}


/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/18 21:32
 * @Description: 自定义线程
 *
 */
public class Test009 {

    public static void main(String[] args) {
        //核心线程数1，最大运行线程数
        //最大线程数2，线程池最多创建的线程数
        //核心线程数 《= 最大线程数
        //存活时间0 ：线程空闲超时时间  不回收，运行就删掉
        //单位：TimeUnit.MILLISECONDS
        //拒绝策略是 最大线程数 + 队列数
        //缓存队列：使用阻塞式队列是因为核心线程数满，往队列中入列和出列都是有时间的，
        // 核心线程数一直满的状态，那么队列中的任务就需要等待
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3));

        //任务1 现在创建线程，在执行
        threadPoolExecutor.execute(new TaskThread("任务1"));
        //任务2 存放在队列缓存
        threadPoolExecutor.execute(new TaskThread("任务2"));
        //任务3 存放在队列缓存
        threadPoolExecutor.execute(new TaskThread("任务3"));
        //任务4 存放在队列缓存
        threadPoolExecutor.execute(new TaskThread("任务4"));
        //任务5 存放在队列缓存 独立线程
        threadPoolExecutor.execute(new TaskThread("任务5"));
        //任务6 存放在队列缓存 直接报错
        //threadPoolExecutor.execute(new TaskThread("任务6"));

    }


}
