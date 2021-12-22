package com.example.test1.service;


import com.example.test1.entity.SaleEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {
    List<SaleEntity> getAllSale(Pageable pageable);
    SaleEntity createSale(SaleEntity saleEntity);
    SaleEntity getSaleById(Integer id);
}
