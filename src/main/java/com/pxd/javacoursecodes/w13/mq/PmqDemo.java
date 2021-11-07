package com.pxd.javacoursecodes.w13.mq;

/**
 * @author by 平向东
 * @date 2021/11/8 0:49 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
public class PmqDemo {

    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.createTopic("topic-1");
        broker.createTopic("topic-2");
        broker.createTopic("topic-3");

        PmqProducer producer = broker.createProducer();
        PmqConsumer consumer = broker.createConsumer();

        producer.send("topic-1",new PmqMessage(null,"this is a new message!"));
        producer.send("topic-1",new PmqMessage(null,"this is a new message at line 1!"));
        producer.send("topic-2",new PmqMessage(null,"this is a new message at line 2!"));

        consumer.subscribe("topic-1");
        PmqMessage poll = consumer.poll(1000);
        System.out.println(poll.getBody());

        poll = consumer.poll(1000);
        System.out.println(poll.getBody());
    }

}
