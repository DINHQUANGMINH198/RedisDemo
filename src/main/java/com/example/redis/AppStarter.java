package com.example.redis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AppStarter implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //RedisProperties.Jedis jedis = new RedisProperties.Jedis("localhost", 6379);
//
//        //Kiểm tra
//        if (!jedis.ping().equals("PONG"))
//        {
//            System.out.println("Redis Server không trả lời");
//        }
//
//        Set<String> keys = jedis.keys("*");
//        keys.forEach(key -> System.out.println("Key: " + key));
    }
}
