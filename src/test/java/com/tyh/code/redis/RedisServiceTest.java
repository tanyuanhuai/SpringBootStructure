package com.tyh.code.redis;

import com.tyh.code.ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * 创建 Administrator 2018-06-29 9:40
 */
public class RedisServiceTest extends ApplicationTests {

    @Autowired
    RedisService redisService;

    @Test
    public void get() {
        String value = redisService.get(GoodsKey.getGoodsDetail,"uuid",String.class);
        System.out.println(value);
    }

    @Test
    public void set() {
        redisService.set(GoodsKey.getGoodsDetail,"uuid","111");
    }

    @Test
    public void exists() {
    }
    @Test
    public void delete() {
        redisService.delete(GoodsKey.getGoodsDetail,"uuid");
    }
}