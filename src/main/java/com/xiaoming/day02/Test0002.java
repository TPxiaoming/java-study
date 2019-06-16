package com.xiaoming.day02;

class ThreadDemo02 implements Runnable {
    /**
     * 同时多个窗口共享100张火车票,静态存放在主内存，方法区中，所有线程都是共享的
     */
    private static int count = 100;
    private static Object oj = new Object();
    public boolean flag = true;

    public void run() {
        if (flag) {
            while (count > 0) {
                synchronized (oj) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    sale();
                }
            }

        } else {
            while (count > 0) {

                sale();
            }
        }
    }

    public synchronized void sale() {
        synchronized (oj) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                // TODO: handle exception
            }
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - count + 1) + "张火车票");
                count--;
            }
        }

    }
}

public class Test0002 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        Thread t1 = new Thread(threadDemo02, "窗口1");
        Thread t2 = new Thread(threadDemo02, "窗口2");
        t1.start();
        Thread.sleep(40);
        threadDemo02.flag = false;
        t2.start();
    }
}
