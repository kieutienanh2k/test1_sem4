package com.example.test1.service;

import com.example.test1.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProduct(Pageable pageable);
    ProductEntity createProduct(ProductEntity productEntity);
    ProductEntity getProductById(Integer id);
    ProductEntity updateProduct(Integer id, ProductEntity p);
}
