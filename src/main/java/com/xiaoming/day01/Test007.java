package com.xiaoming.day01;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/12 21:42
 * @Description:    1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public class Test007 {
    public static void main(String[] args) {

        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("T1, i:" + i);
                }
            }
        });
        final Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("T2, i:" + i);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("T3, i:" + i);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
