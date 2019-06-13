package com.xiaoming.day02;

class ThreadDemo04 extends Thread{
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("线程开始...");
        while(flag){

        }
        System.out.println("线程结束...");
    }

    public void setRuning(boolean flag){
        this.flag = flag;
    }
}
public class Test004 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo04 t1 = new ThreadDemo04();
        t1.start();
        Thread.sleep(3000);
        t1.setRuning(false);
        //主线程进行操作
        System.out.println("flag已经改为false");
        Thread.sleep(1000);
        System.out.println("flag:" + t1.flag);
    }
}
