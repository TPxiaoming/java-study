package com.xiaoming.day07;
/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/23 10:27
 * @Description:    声明一个event 生产者与消费者传递的数据
 */
public class LongEvent {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
