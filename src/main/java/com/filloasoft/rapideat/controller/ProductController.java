package com.filloasoft.rapideat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.filloasoft.rapideat.model.entity.OpenfoodProduct;
import com.filloasoft.rapideat.service.OpenfoodProductService;

@RestController
public class ProductController {

    @Autowired
    OpenfoodProductService productService;

    @GetMapping("/product/{id}")
    public OpenfoodProduct getProduct(@PathVariable String id) {
        return productService.readProductBarcode(id);
    }

    @PostMapping("/example")
    public OpenfoodProduct newExample(@RequestBody OpenfoodProduct newExample) {
        return null;
    }
}
