package com;

//http://ifeve.com/disruptor-getting-started/

/**
 * 自定义数据单元
 * 用户自定义
 */
public class Event {
    private long value;
    public long getValue() { 
        return value; 
    } 
 
    public void setValue(long value) { 
        this.value = value; 
    } 
} 