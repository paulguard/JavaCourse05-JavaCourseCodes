package com.pxd.javacoursecodes.w13.mq;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by 平向东
 * @date 2021/11/8 0:30 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
public final class Broker {

    public static final int CAPACITY = 10000;

    private final Map<String,Pmq> pmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String topicName){
        pmqMap.putIfAbsent(topicName, new Pmq(topicName,CAPACITY));
    }

    public Pmq findPmq(String topic){
        return pmqMap.get(topic);
    }

    public PmqProducer createProducer(){
        return new PmqProducer(this);
    }

    public PmqConsumer createConsumer(){
        return new PmqConsumer(this);
    }

}
