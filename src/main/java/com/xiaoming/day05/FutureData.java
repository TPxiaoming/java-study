package com.xiaoming.day05;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/19 21:29
 * @Description:    当有线程想要获取RealData的时候，程序会被阻塞，等到RealData被注入才会使用getReal()方法。
 */
public class FutureData extends Data {
    //读取结果
    private boolean flag = false;

    private RealData realData;

    /**
     * 读取data数据
     */
    public synchronized void setRealData(RealData realData){
        //如果已经获取到结果，直接返回
        if (flag){
            return;
        }
        //如果flag为false，没有获取到数据，传递readData对象
        this.realData = realData;
        flag = true;
        notify();
    }

    @Override
    public synchronized String getRequest() {
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getRequest();
    }

}
