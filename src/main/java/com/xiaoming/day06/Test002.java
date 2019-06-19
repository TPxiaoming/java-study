package com.xiaoming.day06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/19 22:32
 * @Description: lock 锁具备可重入性 特征：锁是可以传递的（方法递归传递）
 */
public class Test002 extends Thread {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
    }

    public void set() {
        try {
            lock.lock();
            System.out.println("set方法");
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            System.out.println("lock 可以具备可冲入性 -- get方法");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test002 test002 = new Test002();
        test002.start();
    }
}
