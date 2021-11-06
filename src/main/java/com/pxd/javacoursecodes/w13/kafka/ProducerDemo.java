package com.pxd.javacoursecodes.w13.kafka;

import com.pxd.javacoursecodes.w13.kafka.service.ProducerImpl;

/**
 * @author by 平向东
 * @date 2021/11/7 0:53 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
public class ProducerDemo {

    public static void main(String[] args) {
        testProducer();
    }

    private static void testProducer() {
        ProducerImpl producer = new ProducerImpl();
        for (int i = 0; i < 1000; i++) {
            producer.send("Message" + i);
        }
    }

}
