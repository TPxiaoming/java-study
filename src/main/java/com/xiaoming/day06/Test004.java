package com.xiaoming.day06;

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/20 21:29
 * @Description: 两个线程，同时操作一个全局变量，演示线程安全问题 悲观锁
 */
public class Test004 implements Runnable {

    /**
     * 共享的全局变量
     */
    private int count = 1;

    public void run() {
        while (true) {
            Integer count = getCount();
            if (count >= 170){
                break;
            }
            System.out.println(count);
        }
    }

    /**
     * synchronized 可重入、保证原子性和可见性
     * 缺点：只能有一个线程进入，影响效率，不能保证重排序
     *
     * @return
     */
    public synchronized Integer getCount() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count++;
    }

    public static void main(String[] args) {
        Test004 test004 = new Test004();
        Thread t1 = new Thread(test004);
        Thread t2 = new Thread(test004);
        t1.start();
        t2.start();
    }
}
