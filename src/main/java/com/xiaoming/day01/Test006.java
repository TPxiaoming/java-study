package com.xiaoming.day01;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/12 21:31
 * @Description:    join：正在执行A线程，另一个线程B，A线程调用B的这个join方法，作用：A等待B线程执行完毕之后（释放我的CPU执行权），再继续执行
 */
public class Test006 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 60; i++) {
                    System.out.println("子线程，i：" + i);
                }
            }
        });
        thread.start();

        //主线程让子线程先执行完毕的话，怎么做？
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 30; i++) {
            System.out.println("主线程，i：" + i);
        }
    }
}
