package com;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fangxin
 * @date 2017/5/9.
 */
public class Main {

    public static void main(String[] args) {

        PersonFactory factory = new PersonFactory();

        int bufferSize = 1024*1024;

        ExecutorService executors = Executors.newFixedThreadPool(10);

        Disruptor<Person> disruptor = new Disruptor<Person>(factory,bufferSize,executors);
        disruptor.handleEventsWith(new EventConsumer());
        disruptor.start();

        EventProducer2 producer = new EventProducer2(disruptor.getRingBuffer());


        for(int i=0;i<100;i++){
            producer.putData(new Person(i,"aa"+i));
        }

        disruptor.shutdown();
        executors.shutdown();
    }

}
