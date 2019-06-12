package com.xiaoming.day01;

public class Thread003 {
    public static void main(String[] args) {
        System.out.println("main... 主线程开始...");
        //创建线程
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10 ; i++) {
                    System.out.println("子线程 i:" + i);
                }
            }
        });
        //启动线程
        thread.start();
        for (int i = 0; i < 15; i++) {
            System.out.println("main... 主线程 i:" + i);
        }
        System.out.println("main... 主线程结束...");
    }
}
