package com.xiaoming.day03;

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/16 20:52
 * @Description: 共享对象
 */
class Res {
    /**
     * 姓名
     */
    public String name;
    /**
     * 性别
     */
    public String sex;
    /**
     * flag 为 true 情况下 允许读，不能写
     * flag 为 false 情况下 允许写，不能读
     */
    public boolean flag = false;
}

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/16 20:52
 * @Description: 生产者线程
 */
class IntThread extends Thread {
    public Res res;

    public IntThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {
                if (res.flag) {
                    try {
                        //释放当前锁对象，下面写代码不会被执行
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.name = "小红";
                    res.sex = "女";
                } else {
                    res.name = "小明";
                    res.sex = "男";
                }
                //0 1 0 1 0 1
                count = (count + 1) % 2;
                //标记当前线程为等待
                res.flag = true;
                //唤醒被等待的线程
                res.notify();
            }
        }
    }
}

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/16 21:00
 * @Description: 读取线程
 */
class OutThread extends Thread {
    public Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (res) {
                try {
                    if (!res.flag) {
                        res.wait();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(res.name + " -- " + res.sex);
                res.flag = false;
                res.notify();

            }
        }

    }
}

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/16 21:05
 * @Description: 读写线程不能保证原子性，volatile也不能保证,synchronized也可能会出现线程安全问题
 */
public class Test001 {
    public static void main(String[] args) {
        Res res = new Res();
        IntThread intThread = new IntThread(res);
        OutThread outThread = new OutThread(res);
        intThread.start();
        outThread.start();
    }
}
