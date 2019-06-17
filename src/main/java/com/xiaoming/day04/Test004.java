package com.xiaoming.day04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/17 22:34
 * @Description:    executors四种线程池用法
 *                  newCachedThreadPool 可缓存的线程重复使用 无限大小
 */
public class Test004 {

    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            //可执行线程 execute 方法就表示启动线程
            newCachedThreadPool.execute(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }

            });
        }
    }
}
