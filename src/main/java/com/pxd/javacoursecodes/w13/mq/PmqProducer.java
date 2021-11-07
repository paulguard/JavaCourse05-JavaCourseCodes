package com.pxd.javacoursecodes.w13.mq;

/**
 * @author by 平向东
 * @date 2021/11/8 0:34 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
public class PmqProducer {

    private Broker broker;

    public PmqProducer(Broker broker) {
        this.broker = broker;
    }

    public boolean send(String topic,PmqMessage message){
        Pmq pmq = broker.findPmq(topic);
        if (pmq == null) {
            throw new RuntimeException("Topic["+ topic +"] doesn't exist");
        }

        return pmq.send(message);
    }
}
