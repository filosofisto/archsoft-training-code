package com.archsoft.amazon.controller;

import com.archsoft.amazon.model.Product;
import com.archsoft.amazon.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/{code}")
    public ResponseEntity<Product> getQuote(@PathVariable("code") String code) {
        return ResponseEntity.ok(productService.findByCode(code));
    }

}
