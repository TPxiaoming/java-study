package com.xiaoming.day01;

/**
 * @author xiaoming
 * @date 2019/06/11
 * 1.实现runable接口，重写run方法，run方法中，需要线程执行代码
 */
class ThreadDemo02 implements Runnable{

    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println("子线程 i:" + i);
        }
    }
}

/**
 * @author xiaoming
 * @date 2019/06/11
 *
 */
public class Thead002 {
    public static void main(String[] args) {
        System.out.println("main... 主线程开始...");
        //创建线程
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        Thread t1 = new Thread(threadDemo02);
        //启动线程
        t1.start();
        for (int i = 0; i < 15; i++) {
            System.out.println("main... 主线程 i:" + i);
        }
        System.out.println("main... 主线程结束...");
    }
}
