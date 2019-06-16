package com.xiaoming.day04;

import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/16 22:43
 * @Description:    阻塞式队列最大好处，能够防止队列容器溢出，防止丢失数据。
 *                  先进先出，后进后出
 */
public class Test001 {

    public static void main(String[] args) {
        //非阻塞式队列， 无界队列
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.offer("张三");
        concurrentLinkedQueue.offer("李四");
        concurrentLinkedQueue.offer("小明");
        //获取队列 只能获取一个队列元素，并且删除该元素
        System.out.println(concurrentLinkedQueue.poll());
        //获取队列 只能获取一个队列元素，不会删除该元素，一般不会用该方法
        System.out.println(concurrentLinkedQueue.peek());
        //获取队列的个数
        System.out.println(concurrentLinkedQueue.size());
    }

}
