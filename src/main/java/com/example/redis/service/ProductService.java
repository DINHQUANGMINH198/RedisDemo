package com.example.redis.service;

import com.example.redis.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll();

    ProductEntity getById(long id);
}
