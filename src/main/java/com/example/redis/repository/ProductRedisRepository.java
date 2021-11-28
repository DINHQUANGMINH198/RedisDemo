package com.example.redis.repository;

import com.example.redis.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRedisRepository {

    @Autowired
    RedisTemplate<String, String> template;

    List<ProductEntity> findAll() {
        return null;
    }

}
