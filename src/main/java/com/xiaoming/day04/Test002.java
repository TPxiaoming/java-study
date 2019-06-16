package com.xiaoming.day04;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/16 23:00
 * @Description:    阻塞式队列，如果存队列的时候，如果满了，就会等待
 *                  如果获取不到，也会等待
 */
public class Test002 {

    public static void main(String[] args) throws InterruptedException {
        //最多支持队列总数  阻塞式队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        //添加非阻塞式队列
        blockingQueue.offer("张三");
        //添加阻塞式队列
        blockingQueue.offer("李四", 3, TimeUnit.SECONDS);
        //添加非阻塞式队列
        blockingQueue.offer("小明");
        //添加阻塞式队列
        boolean offer = blockingQueue.offer("佩佩", 3, TimeUnit.SECONDS);

        //前面这段代码运行需要 3 秒， 佩佩需要等待， 如果没有人取。佩佩存不进去， 会丢失
        System.out.println(offer);

        System.out.println(blockingQueue.poll());
        //不会等待， 原因：队列没有满，能取到值，没有满
        System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));
        //会等待， 原因：队列为空，阻塞 3 秒
        System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));
    }

}
