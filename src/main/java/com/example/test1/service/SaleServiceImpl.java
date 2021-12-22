package com.example.test1.service;

import com.example.test1.entity.SaleEntity;
import com.example.test1.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepo saleRepo;

    @Override
    public List<SaleEntity> getAllSale(Pageable pageable) {
        return saleRepo.findAll();
    }

    @Override
    public SaleEntity createSale(SaleEntity saleEntity) {
        return saleRepo.save(saleEntity);
    }

    @Override
    public SaleEntity getSaleById(Integer id) {
        return saleRepo.findById(id).orElse(null);
    }
}
