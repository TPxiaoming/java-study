package com.xiaoming.day05;

public class Test002 extends  Thread{

    /**
     * 执行下载请求（大概耗时10分种）
     */
    @Override
    public void run() {
        //下载...
        //如果我先发获取run方法执行结果，必须要执行完毕才能获取到结果，整个程序是阻塞的。
    }

    public static void main(String[] args) {
        Test002 test002 = new Test002();
        test002.start();
        //主线程如何知道子线程程序执行完毕。 使用wait和notify通知主线程
    }

}
