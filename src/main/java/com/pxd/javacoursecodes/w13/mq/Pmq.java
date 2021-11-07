package com.pxd.javacoursecodes.w13.mq;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import lombok.Data;
import lombok.SneakyThrows;

/**
 * @author by 平向东
 * @date 2021/11/8 0:26 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
@Data
public class Pmq {

    private String topic;

    private int capacity;

    private LinkedBlockingQueue<PmqMessage> queue;

    public Pmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new LinkedBlockingQueue(capacity);
    }

    public boolean send(PmqMessage message){
        return queue.offer(message);
    }

    public PmqMessage poll(){
        return queue.poll();
    }

    @SneakyThrows
    public PmqMessage poll(long timeout){
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }
}
