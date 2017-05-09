package com;

import com.lmax.disruptor.EventFactory;


// 需要让disruptor为我们创建数据。通过继承disruptor的EventFactory并实现接口
public class LongEventFactory implements EventFactory { 

    @Override
    public Object newInstance() {
        return new LongEvent(); 
    } 
} 