package com.xiaoming.day07.consumer;

import com.lmax.disruptor.EventHandler;
import com.xiaoming.day07.LongEvent;

/**
 * @Author: xiaoming
 * @CreateDate: 2019/6/23 10:31
 * @Description: 事件消费者，也就是一个事件处理器
 * 只要实现 EventHandler 接口，就可以接受到 生产者推送数据
 */
public class LongEventHandler2 implements EventHandler<LongEvent> {

    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("消费者2 获取生产者数据...longEvent:" + longEvent.getValue());
    }

}
