package com.xiaoming.day05;


public class Test001 extends Thread{

    @Override
    public void run() {
        //特别多代码...省略... 没有阻塞情况
        //阻塞的情况产生的原因， 请求、读取数据库、循环、IO操作 可能会发生阻塞
        //http.post() --- 阻塞2秒
        //IO密集： 该任务需要大量的IO操作，产生阻塞，如果在单线程中执行阻塞，浪费CPU。
        // 可以使用多线程技术，CPU运算能力 不会浪费等待资源。多配置线程数 最大线程数 = 2 * CPU核数



        //CPU密集：执行该任务的时候，不会产生大量的IO阻塞，CPU运行的时候速度特别快。配置线程数 最大线程数 =  CPU核数
    }
}
