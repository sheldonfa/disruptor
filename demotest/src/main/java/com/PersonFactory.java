package com;

import com.lmax.disruptor.EventFactory;

/**
 * @author fangxin
 * @date 2017/5/9.
 */
public class PersonFactory implements EventFactory {

    private int i = 0;
    private String name = "gogo";

    @Override
    public Person newInstance() {
        return new Person(i++,name+i);
    }
}
