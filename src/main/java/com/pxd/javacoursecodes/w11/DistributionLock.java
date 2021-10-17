package com.pxd.javacoursecodes.w11;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 实现一个分布式锁
 */
@Component
public class DistributionLock {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 获取锁
     * @param lockId
     * @param millsec
     * @return
     */
    public boolean getLock(String lockId,long millsec){
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock", millsec, TimeUnit.MILLISECONDS);
        return success != null && success;
    }

    /**
     * 释放锁
     * @param lockId
     */
    public void releaseLock(String lockId){
        redisTemplate.delete(lockId);
    }
}
