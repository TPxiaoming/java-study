package com.xiaoming.day06;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/19 22:24
 * @Description:    重入锁 轻量级（Lock）与重量级锁（Synchronized）--可重入性（递归锁）
 */
public class Test001  implements Runnable{

    public void run() {
        set();
    }

    /**
     * synchronized：this锁 是什么时候释放锁？ 代码结束后
     * set 和 get 都是this锁，set方法的锁没有释放，如果不可重入，
     * 无法获取get方法的锁，会产生死锁
     */
    public synchronized void set(){
        System.out.println("set方法");
        get();
    }

    public synchronized void get(){
        System.out.println("synchronized 可以具备可冲入性 -- get方法");
    }

    public static void main(String[] args) {
        Test001 test001 = new Test001();
        Thread t1 = new Thread(test001);
        t1.start();
    }
}
