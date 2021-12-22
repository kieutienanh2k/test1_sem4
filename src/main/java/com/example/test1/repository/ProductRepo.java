package com.example.test1.repository;

import com.example.test1.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
//    List<ProductEntity> findAll(Pageable pageable);
}
