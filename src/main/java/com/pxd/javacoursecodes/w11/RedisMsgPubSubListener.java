package com.pxd.javacoursecodes.w11;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import com.pxd.javacoursecodes.w7.entity.Soh;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

/**
 * java实现pubSub模式
 */
@Slf4j
@Component
public class RedisMsgPubSubListener extends JedisPubSub {

    @Resource
    private SohService sohService;

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log.info("onSubscribe: channel[{}], subscribedChannels[{}]", channel, subscribedChannels);
    }

    @Override
    public void onMessage(String channel, String message) {
        log.info("onMessage: channel[{}], message[{}]",channel, message);

        if (channel.equals("soh_verify")) {
            Soh soh = JSON.parseObject(message, Soh.class);
            sohService.verifySoh(soh);
        }
    }
}
