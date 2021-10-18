package com.pxd.javacoursecodes.w11;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

/**
 * java实现pubSub模式
 */
@Slf4j
public class RedisMsgPubSubListener extends JedisPubSub {

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log.info("onSubscribe: channel[{}], subscribedChannels[{}]", channel, subscribedChannels);
    }

    @Override
    public void onMessage(String channel, String message) {
        log.info("onMessage: channel[{}], message[{}]",channel, message);
    }
}
