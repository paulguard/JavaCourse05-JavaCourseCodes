package com.pxd.javacoursecodes.w13.kafka;

import com.pxd.javacoursecodes.w13.kafka.service.ConsumerImpl;

/**
 * @author by 平向东
 * @date 2021/11/7 0:53 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        testConsumer();
    }

    private static void testConsumer() {
        ConsumerImpl consumer = new ConsumerImpl();
        consumer.consume();

    }

}
