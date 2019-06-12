package com.xiaoming.day01;

public class Test004 {
    /**
     * 用户线程 是主线程创建的线程，非守护线程
     * 守护线程 和主线程一起销毁
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程，i：" + i);
                }
            }
        });
        //设置该线程为守护线程 和 主线程一起销毁
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程，i：" + i);
        }
        System.out.println("主线程执行完毕。。。。。。");

    }
}
