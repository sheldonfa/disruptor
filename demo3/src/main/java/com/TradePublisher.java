package com;

import java.util.Random;
import java.util.concurrent.CountDownLatch;


import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

public class TradePublisher implements Runnable {  
	
    Disruptor<Trade> disruptor;  
    private CountDownLatch latch;  
    
    private static int LOOP=10;//模拟百万次交易的发生  
  
    public TradePublisher(CountDownLatch latch,Disruptor<Trade> disruptor) {  
        this.disruptor=disruptor;  
        this.latch=latch;  
    }  
  
    @Override  
    public void run() {  
    	TradeEventTranslator tradeTranslator = new TradeEventTranslator();
        for(int i=0;i<LOOP;i++){  
            disruptor.publishEvent(tradeTranslator);
        }
        System.out.println("生产完毕");
        // 通知其他线程，生产完毕
        latch.countDown();
    }  
      
}  
  
class TradeEventTranslator implements EventTranslator<Trade>{  
    
	private Random random=new Random();  
    
	@Override  
    public void translateTo(Trade event, long sequence) {  
        this.generateTrade(event);  
    }
    
	private Trade generateTrade(Trade trade){  
        trade.setPrice(random.nextDouble()*9999);  
        return trade;  
    }  
	
}  