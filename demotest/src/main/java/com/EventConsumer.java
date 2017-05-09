package com;


import com.lmax.disruptor.EventHandler;

/**
 * @author fangxin
 * @date 2017/5/9.
 */
public class EventConsumer implements EventHandler<Person> {

    @Override
    public void onEvent(Person person, long l, boolean b) throws Exception {
        System.out.println(person);
    }
}
