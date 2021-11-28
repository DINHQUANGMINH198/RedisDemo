package com.example.redis.service;

import com.example.redis.entity.ProductEntity;
import com.example.redis.repository.ProductRedisRepository;
import com.example.redis.repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductRedisRepository productRedisRepository;

    @Autowired
    RedisTemplate<String, String> redis;

    final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<ProductEntity> getAll() {
        // Ưu tiên lấy ở Redis trước.
        try {
            List<ProductEntity> products;
            String jsonProducts;
            if (Boolean.FALSE.equals(redis.hasKey("products"))) {
                products = productRepository.findAll();
                jsonProducts = mapper.writeValueAsString(products);
                redis.opsForValue().set("products", jsonProducts);
                return products;
            }

            jsonProducts = redis.opsForValue().get("products");
            products = mapper.readValue(jsonProducts, new TypeReference<List<ProductEntity>>(){});
            return products;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public ProductEntity getById(long id) {
        try {
            ProductEntity product;
            String jsonProduct;
            if (Boolean.FALSE.equals(redis.hasKey("product-" + id))) {
                Optional<ProductEntity> respProduct = productRepository.findById(id);
                if (respProduct.isPresent()) {
                    product = respProduct.get();
                    jsonProduct = mapper.writeValueAsString(product);
                    redis.opsForValue().set("product-" + id, jsonProduct);
                    return product;
                }
                return null;
            }

            jsonProduct = redis.opsForValue().get("product-" + id);
            product = mapper.readValue(jsonProduct, ProductEntity.class);
            return product;
        } catch (Exception ex) {
            return null;
        }
    }
}
