package com.example.test1.controller;

import com.example.test1.entity.ProductEntity;
import com.example.test1.model.BaseResponse;
import com.example.test1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity getAllProduct(
                                        @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                        @RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit){
        BaseResponse res = new BaseResponse();
        res.data = productService.getAllProduct(PageRequest.of(page, limit));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get_by_id")
    public ResponseEntity findProductById(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id){
        BaseResponse res = new BaseResponse();
        res.data = productService.getProductById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProductEntity productEntity) {
        ProductEntity entity = new ProductEntity();
        entity.setName(productEntity.getName());
        entity.setPrice(productEntity.getPrice());
        entity.setDescription(productEntity.getDescription());
        entity.setDate_of_man(productEntity.getDate_of_man());

        BaseResponse res = new BaseResponse();
        res.data = productService.createProduct(entity);

        return ResponseEntity.ok(res);

    }
    @PutMapping
    public ResponseEntity update(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id,
                                 @RequestBody ProductEntity productEntity) {
        ProductEntity entity = new ProductEntity();
        entity.setName(productEntity.getName());
        entity.setPrice(productEntity.getPrice());
        entity.setDescription(productEntity.getDescription());
        entity.setDate_of_man(productEntity.getDate_of_man());

        return ResponseEntity.ok(productService.updateProduct(id, entity));

    }

//    @DeleteMapping
//    public ResponseEntity delete(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id){
//        return ResponseEntity.ok(productService.deleteProduct(id));
//    }

}
