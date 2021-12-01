package com.example.redis.service;

import com.example.redis.entity.ProductEntity;
import com.example.redis.request.CreateProductRequest;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll();

    ProductEntity getById(long id);

    void create(CreateProductRequest request);
}
