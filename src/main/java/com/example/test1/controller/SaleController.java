package com.example.test1.controller;

import com.example.test1.entity.ProductEntity;
import com.example.test1.entity.SaleEntity;
import com.example.test1.model.BaseResponse;
import com.example.test1.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity create(@RequestBody SaleEntity saleEntity) {
        SaleEntity entity = new SaleEntity();
        entity.setName(saleEntity.getName());
        entity.setProduct_id(saleEntity.getProduct_id());
        entity.setDos(saleEntity.getDos());
        entity.setSale_man_id(saleEntity.getSale_man_id());

        BaseResponse res = new BaseResponse();
        res.data = saleService.createSale(entity);

        return ResponseEntity.ok(res);

    }
    @GetMapping("/get_by_id")
    public ResponseEntity findSaleById(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id){
        BaseResponse res = new BaseResponse();
        res.data = saleService.getSaleById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity getAllSale(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit){
        BaseResponse res = new BaseResponse();
        res.data = saleService.getAllSale(PageRequest.of(page, limit));
        return ResponseEntity.ok(res);
    }
}
