package com.xiaoming.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口的call方法
 */
class ThreadDemo05 implements Callable<String>{

    public String call() throws Exception {
        return "hello";
    }
}

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/12 21:13
 * @Description:
 */
public class Test005 {
    public static void main(String[] args) {
        //创建线程
        FutureTask<String> futureTask = new FutureTask<String>(new ThreadDemo05());
        //启动线程
        new Thread(futureTask).start();
        try{
            //等待线程执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
