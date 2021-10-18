package com.pxd.javacoursecodes;

import javax.annotation.Resource;

import com.pxd.javacoursecodes.w11.DistributionCounter;
import com.pxd.javacoursecodes.w11.DistributionLock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

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

}
