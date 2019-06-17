package com.xiaoming.day04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/17 22:48
 * @Description:    newScheduledThreadPool
 */
public class Test006 {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            //可执行线程 execute 方法就表示启动线程  3 秒之后再进行定时调度
            newScheduledThreadPool.schedule(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }

            },3, TimeUnit.SECONDS);
            //execute 不会定时调度
            /*newScheduledThreadPool.execute(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }

            });*/
        }
    }
}
