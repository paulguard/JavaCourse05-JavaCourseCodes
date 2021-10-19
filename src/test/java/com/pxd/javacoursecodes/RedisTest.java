package com.pxd.javacoursecodes;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import com.pxd.javacoursecodes.w11.DistributionCounter;
import com.pxd.javacoursecodes.w11.DistributionLock;
import com.pxd.javacoursecodes.w11.RedisMsgPubSubListener;
import com.pxd.javacoursecodes.w7.entity.Soh;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * @author by 平向东
 * @date 2021/10/18 1:04 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private DistributionLock distributionLock;

    @Resource
    private DistributionCounter distributionCounter;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private RedisMsgPubSubListener redisMsgPubSubListener;

    @Test
    public void testDistributionLock(){

        boolean lock = distributionLock.getLock("112233", 300000);
        System.out.println(lock);

        System.out.println(redisTemplate.getClientList().get(0).get("112233"));

        distributionLock.releaseLock("112233");

    }

    @Test
    public void testDistributionCounter(){

        Runnable runnable = () -> distributionCounter.count();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }

        Long count = distributionCounter.count();

        System.out.println(count);
    }

    @Test
    public void testSubscribe(){

        Jedis jedis = null;
        try {
            jedis = new Jedis("127.0.0.1", 6379,0);
            jedis.subscribe(redisMsgPubSubListener,"tv","radio","soh_verify");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(jedis).disconnect();
        }

    }

    @Test
    public void testPublisher(){

        Jedis jedis = null;
        try {
            jedis = new Jedis("127.0.0.1", 6379);
            jedis.publish("tv","This is tv show!");
            jedis.publish("radio","This is ap news on a radio");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(jedis).disconnect();
        }

    }

    @Test
    public void testVerifySoh(){

        Soh soh = new Soh();
        soh.setCreatorId(1L);
        soh.setCreateTime(new Date());
        soh.setCode("2021-9-20-"+System.currentTimeMillis()+ Math.random());
        soh.setStatus("222");
        soh.setBuyerName("buyerName");
        soh.setBuyerProvince("浙江省");
        soh.setBuyerCity("杭州市");
        soh.setBuyerCounty("拱墅区");
        soh.setBuyerDetailAddr("贡院9幢406室");
        soh.setUserId(3L);

        String message = JSON.toJSONString(soh);

        Jedis jedis = null;
        try {
            jedis = new Jedis("127.0.0.1", 6379);
            jedis.publish("soh_verify",message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(jedis).disconnect();
        }

    }

}
