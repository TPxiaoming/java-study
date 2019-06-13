package com.xiaoming.day02;

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/12 22:23
 * @Description: 窗口线程
 */
class ThreadDemo01 implements Runnable {
    /**
     * 同时多个窗口共享100张火车票,静态存放在主内存，方法区中，所有线程都是共享的
     */
    private static int count = 100;

    private static Object obj = new Object();

    /**
     * 如果 synchronized 加在run方法前就成了单线程了
     */
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    /**
     * 使用synchronized只能有一个线程执行 同步方法
     */
   /* public synchronized void sale() {
        //继续判断的原因：t1 和 t2 在等待，同时对该方法进行操作，还有一张火车票
        //当t1进行--之后，等待的线程t2进来继续--
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - count + 1) + "张火车票");
            count -- ;
        }
    }*/

    /**
     * 同步代码块
     */
    public  void sale() {
        //继续判断的原因：t1 和 t2 在等待，同时对该方法进行操作，还有一张火车票
        //当t1进行--之后，等待的线程t2进来继续--
        synchronized (obj) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - count + 1) + "张火车票");
                count--;
            }
        }
    }
}

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/12 22:20
 * @Description: 案例:需求现在有100张火车票，有两个窗口同时抢火车票，请使用多线程模拟抢票效果。
 */
public class Test001 {
    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        ThreadDemo01 threadDemo02 = new ThreadDemo01();
        Thread thread1 = new Thread(threadDemo01,"窗口1");
        Thread thread2 = new Thread(threadDemo02,"窗口2");
        thread1.start();
        thread2.start();
    }
}
