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
 */
public class Test009 {

    public static void main(String[] args) {
        //核心线程数1，实际运用线程数
        //最大线程数2，线程池最多创建的线程数
        //存活时间0 ：线程空闲超时时间  不回收，运行就删掉
        //单位：TimeUnit.MILLISECONDS
        //拒绝策略是 最大线程数 + 队列数

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
        //任务5 存放在队列缓存
        threadPoolExecutor.execute(new TaskThread("任务5"));
        //任务6 存放在队列缓存
        threadPoolExecutor.execute(new TaskThread("任务6"));

    }


}
