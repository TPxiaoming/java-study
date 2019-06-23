package com.xiaoming.day07.producer;

import com.lmax.disruptor.RingBuffer;
import com.xiaoming.day07.LongEvent;

import java.nio.ByteBuffer;

/**
 * @Author:         xiaoming
 * @CreateDate:     2019/6/23 11:19
 * @Description:    生产者
 */
public class LongEventProducer {

    private RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer){
        //拿到环形的序列位置  获取事件队列的下标位置
        long sequence = ringBuffer.next();
        try {
            //取出空队列（Event）
            LongEvent longEvent = ringBuffer.get(sequence);
            //给空队列赋值
            longEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者发送数据.....");
            //发送数据
            ringBuffer.publish(sequence);
        }

    }

}
