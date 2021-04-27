package com.archsoft.mongodb.controller;

import com.archsoft.mongodb.converter.ProductConverter;
import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.service.ProductService;
import com.archsoft.mongodb.to.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    private final ProductConverter productConverter;

    @Autowired
    public ProductController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @PostMapping
    public ResponseEntity<ProductTO> create(@RequestBody ProductTO productTO) {
        Product product = productConverter.toEntity(productTO);
        Product productResponse = productService.create(product);

        return ResponseEntity.ok(productConverter.toTransferObject(productResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTO> read(@PathVariable("id") String id) throws RecordNotFoundException {
        Product productResponse = productService.find(id);

        return ResponseEntity.ok(productConverter.toTransferObject(productResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) throws RecordNotFoundException {
        productService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<ProductTO> update(@RequestBody ProductTO productTO) throws RecordNotFoundException {
        Product product = productConverter.toEntity(productTO);
        Product productResponse = productService.update(product);

        return ResponseEntity.ok(productConverter.toTransferObject(productResponse));
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductTO>> list() {
        List<Product> list = productService.list();

        return ResponseEntity.ok(productConverter.toTransferObject(list));
    }

    @GetMapping("/findByDescription")
    public ResponseEntity<Iterable<ProductTO>> query(@RequestParam("description") String description) {
        Iterable<Product> list = productService.findByDescription(description);

        return ResponseEntity.ok(productConverter.toTransferObject(list));
    }
}
