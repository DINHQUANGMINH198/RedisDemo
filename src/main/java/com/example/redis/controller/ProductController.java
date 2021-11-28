package com.example.redis.controller;

import com.example.redis.entity.ProductEntity;
import com.example.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        List<ProductEntity> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") long id) {
        ProductEntity product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
