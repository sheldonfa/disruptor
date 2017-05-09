package com;

import com.lmax.disruptor.RingBuffer;

/**
 * @author fangxin
 * @date 2017/5/9.
 */
public class EventProducer {

    private RingBuffer<Person> ringBuffer;

    public EventProducer(RingBuffer<Person> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }


    public void putData(Person person){
        long sequence = ringBuffer.next();
        try{
            Person p = ringBuffer.get(sequence);
            p.setName(person.getName());
            p.setId(person.getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ringBuffer.publish(sequence);
        }

    }
}
