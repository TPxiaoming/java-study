package com.xiaoming.day05;

import java.util.concurrent.*;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/18 23:15
 * @Description:    Future模式
 */
class TaskFuture implements Callable<String>{

    public String call() throws Exception {
        System.out.println("3.正在执行任务，需要等待五秒时间，执行任务开始");
        Thread.sleep(5000);
        System.out.println("4.正在执行任务，需要等待五秒时间，执行任务结束");
        return "小明";
    }

}


public class Test003 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        final Future<String> submit = newCachedThreadPool.submit(new TaskFuture());
        Thread.sleep(200);
        System.out.println("1.主线程开始执行...");
        new Thread(new Runnable() {
            public void run() {

                //获取执行结果 该方法是阻塞的
                String result = null;
                try {
                    result = submit.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println("2.result:" + result);
            }
        }).start();
        //Future模式
        System.out.println("5.主线程执行任务...");
    }
}
