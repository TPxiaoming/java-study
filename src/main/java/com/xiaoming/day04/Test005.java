package com.xiaoming.day04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/17 22:43
 * @Description:    newFixedThreadPool 可固定长度线程池
 */
public class Test005 {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            //可执行线程 execute 方法就表示启动线程
            newFixedThreadPool.execute(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }

            });
        }
    }
}
