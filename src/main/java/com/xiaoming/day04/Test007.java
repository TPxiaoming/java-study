package com.xiaoming.day04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/17 22:53
 * @Description:    newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class Test007 {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            //可执行线程 execute 方法就表示启动线程
            newSingleThreadExecutor.execute(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }

            });
        }
        newSingleThreadExecutor.shutdown();
    }
}
