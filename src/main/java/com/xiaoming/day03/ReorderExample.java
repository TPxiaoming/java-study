package com.xiaoming.day03;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/15 19:31
 * @Description:    重排序问题，1和2没有依赖关系，2可能因为重排序在1之前执行，可能导致读线程在2之前执行，得到 i=0，使用volatile可以禁止重排序
 */
public class ReorderExample {
    volatile int a = 0;
    boolean flag = false;

    /**
     * 写线程
     */
    public void writer(){
        //1
        a = 1;
        //2
        flag = true;
    }

    /**
     * 读线程
     */
    public void reader(){
        //3
        if (flag){
            //4
            int i = a * a;
        }
    }
}
