package com;



// 需要让disruptor为我们创建数据。通过继承disruptor的EventFactory并实现接口
public class EventFactory implements com.lmax.disruptor.EventFactory {

    @Override
    public Object newInstance() {
        return new Event();
    } 
} 