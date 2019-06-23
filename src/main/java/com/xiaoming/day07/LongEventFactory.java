package com.xiaoming.day07;

import com.lmax.disruptor.EventFactory;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/23 10:29
 * @Description:    EventFactory 实例化 Event 对象，必须实现 EventFactory 接口，参数是你要实现的对象
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }

}
