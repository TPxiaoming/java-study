package com.xiaoming.day07.producer;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.xiaoming.day07.LongEvent;
import com.xiaoming.day07.LongEventFactory;
import com.xiaoming.day07.consumer.LongEventHandler;
import com.xiaoming.day07.consumer.LongEventHandler2;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        //1.创建可以缓存的线程池，提供发给consumer使用的
        ExecutorService executor = Executors.newCachedThreadPool();
        //2.创建工厂
        EventFactory eventFactory = new LongEventFactory();
        //3.设置环形数组的大小 一定要是 2 的 你次方
        int ringBufferSize = 1024 * 1024;
        //4.创建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, ringBufferSize, executor, ProducerType.MULTI, new YieldingWaitStrategy());
        //5.连接消费者 --- 相当于注册消费者  重复消费
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.handleEventsWith(new LongEventHandler2());
        //多个消费者一个生产者 默认重复消费、配置分组
        //6.启动
        disruptor.start();
        //7.创建RingBuffer容器
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //8.创建生产者
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        //9.指定缓冲区的大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 100; i++) {
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
        }
        executor.shutdown();
        disruptor.shutdown();
}

}
