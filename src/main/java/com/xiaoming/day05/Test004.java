package com.xiaoming.day05;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/19 21:23
 * @Description:    Future模式
 */
public class Test004 {

    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data request = futureClient.request("小猪佩狗");
        System.out.println("主线程数据发送成功");
        System.out.println("主线程执行其他任务");
        String result = request.getRequest();
        System.out.println("主线程获取result：" + result);
    }

}
