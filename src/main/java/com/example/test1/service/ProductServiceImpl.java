package com.example.test1.service;

import com.example.test1.entity.ProductEntity;
import com.example.test1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo proRepo;

    @Override
    public List<ProductEntity> getAllProduct(Pageable pageable) {
        return proRepo.findAll(pageable).getContent();
    }

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return proRepo.save(productEntity);
    }

    @Override
    public ProductEntity getProductById(Integer id) {
        return proRepo.findById(id).orElse(null);
    }

    @Override
    public ProductEntity updateProduct(Integer id, ProductEntity p) {
        ProductEntity productEntity = proRepo.getById(id);
        if (productEntity != null){
            productEntity.setName(p.getName());
            productEntity.setPrice(p.getPrice());
            productEntity.setDate_of_man(p.getDate_of_man());
            productEntity.setDescription(p.getDescription());
            return proRepo.save(productEntity);
        }
        return null;
    }
}
