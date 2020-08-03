package com.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo
 * Date 2020/7/31 11:42
 */
@Component
public class RedisTempletUtil {

    private RedisTemplate redisTemplate;

    private RedisTempletUtil(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public void setExpire(String key, Long expireTime){
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    public void setData(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void setDataForExpire(String key, Object value, Long time){
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    public void deleteData(String key){
        redisTemplate.delete(key);
    }

    public JSONObject getData(String key){
        Object value =  redisTemplate.opsForValue().get(key);

        JSONObject json = JSONObject.parseObject(value.toString());

        return json;
    }

}
