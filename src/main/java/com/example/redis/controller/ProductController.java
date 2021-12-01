package com.example.redis.controller;

import com.example.redis.entity.ProductEntity;
import com.example.redis.request.CreateProductRequest;
import com.example.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add-product")
    public String create(@RequestBody CreateProductRequest request) {
        productService.create(request);
        return "Thanh cong";
    }
}
