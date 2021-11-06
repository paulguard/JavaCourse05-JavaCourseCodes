package com.pxd.javacoursecodes.w13.kafka.service;

import java.util.Properties;

import com.alibaba.fastjson.JSON;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author by 平向东
 * @date 2021/11/7 0:47 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
public class ProducerImpl implements Producer {

    private Properties properties;
    private KafkaProducer<String, String> producer;
    private final String topic = "test-topic-1";

    public ProducerImpl() {
        properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(properties);
        //producer.initTransactions();
    }

    @Override
    public void send(String message) {
        try {
            //producer.beginTransaction();
            ProducerRecord record = new ProducerRecord(topic, message);
            producer.send(record, (metadata, exception) -> {
                //                if (exception != null) {
                //                    producer.abortTransaction();
                //                    throw new KafkaException(exception.getMessage() + " , data: " + record);
                //                }
            });
            //producer.commitTransaction();

        } catch (Throwable e) {
            //producer.abortTransaction();
        }
        //System.out.println("************" + json + "************");
    }

    @Override
    public void close() {
        producer.close();
    }
}
