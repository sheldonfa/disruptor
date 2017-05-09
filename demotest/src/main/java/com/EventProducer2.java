package com;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

/**
 * @author fangxin
 * @date 2017/5/9.
 */
public class EventProducer2 {

    private RingBuffer<Person> ringBuffer;

    public EventProducer2(RingBuffer<Person> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<Person,Person> TRANSLATOR = new EventTranslatorOneArg<Person, Person>() {
        @Override
        public void translateTo(Person event, long sequence, Person arg0) {
            event.setId(arg0.getId());
            event.setName(arg0.getName());
        }
    };

    public void putData(Person person){
        ringBuffer.publishEvent(TRANSLATOR,person);
    }
}
