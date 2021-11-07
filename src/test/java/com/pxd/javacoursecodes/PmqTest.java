package com.pxd.javacoursecodes;

import com.pxd.javacoursecodes.w13.mq.Broker;
import com.pxd.javacoursecodes.w13.mq.PmqConsumer;
import com.pxd.javacoursecodes.w13.mq.PmqMessage;
import com.pxd.javacoursecodes.w13.mq.PmqProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author by 平向东
 * @date 2021/11/8 0:42 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
@SpringBootTest
public class PmqTest {

    @Test
    public void test(){

        Broker broker = new Broker();
        broker.createTopic("topic-1");

        PmqProducer producer = broker.createProducer();
        PmqConsumer consumer = broker.createConsumer();

        producer.send("topic-1",new PmqMessage(null,"this is a new message!"));

        PmqMessage poll = consumer.poll(1000);
        System.out.println(poll.getBody());
    }

}
