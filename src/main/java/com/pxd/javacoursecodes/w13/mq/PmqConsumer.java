package com.pxd.javacoursecodes.w13.mq;

/**
 * @author by 平向东
 * @date 2021/11/8 0:34 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
public class PmqConsumer<T> {

    private final Broker broker;

    private Pmq pmq;

    public PmqConsumer(Broker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic){
        pmq = this.broker.findPmq(topic);
        if (pmq == null) {
            throw new RuntimeException("Topic["+ topic +"] doesn't exist");
        }
    }

    public PmqMessage<T> poll(long timeout){
        if (pmq == null) {
            throw new RuntimeException("Topic doesn't exist");
        }
        return pmq.poll(timeout);
    }
}
