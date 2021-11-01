package com.pxd.javacoursecodes.w12.activemq;

import java.util.Objects;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

/**
 * ActiveMq的启动程序
 */
public class ActivemqApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        //testQueueDestination(new ActiveMQQueue("queue-1"));
        testQueueDestination(new ActiveMQTopic("topic-1"));

    }

    private static void testQueueDestination(Destination destination) {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");

        Session session = null;
        try {
            ActiveMQConnection conn = (ActiveMQConnection)activeMQConnectionFactory.createConnection();
            conn.start();


            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        } catch (JMSException e) {
            e.printStackTrace();
        }

        createConsumer(destination, session);
        MessageProducer producer = createProducer(destination, session);

        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = createTextMessage(Objects.requireNonNull(session), i);
            try {
                producer.send(textMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }

    private static TextMessage createTextMessage(Session session, int i) {

        TextMessage textMessage = null;
        try {
            textMessage = session.createTextMessage("Message" + (i + 1));
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return textMessage;
    }

    private static MessageProducer createProducer(Destination destination, Session session) {
        MessageProducer producer = null;
        try {
            producer = Objects.requireNonNull(session).createProducer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return producer;
    }

    private static void createConsumer(Destination destination, Session session) {
        MessageConsumer consumer;
        try {
            consumer = Objects.requireNonNull(session).createConsumer(destination);
            MessageListener listener = message -> System.out.println("message:"+message);
            consumer.setMessageListener(listener);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
