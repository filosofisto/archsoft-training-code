package com.archsoft.controller;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Product;
import com.archsoft.service.ProductService;
import com.archsoft.to.CheckAvailabilityRequestTO;
import com.archsoft.to.CheckAvailabilityResponseTO;
import com.archsoft.to.ProductTO;
import com.archsoft.util.converter.ProductConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

//    @Value("${server.port}")
//    private Integer port;

    private final ProductService productService;

    private final ProductConverter productConverter;

    public ProductController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductTO> create(@RequestBody ProductTO productTO) {
        Product product = productConverter.toEntity(productTO);
        Product productResponse = productService.create(product);

        return ResponseEntity.ok(productConverter.toTransferObject(productResponse));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ProductTO> read(@PathVariable("id") String id) throws RecordNotFoundException {
        Product productResponse = productService.find(id);

        return ResponseEntity.ok(productConverter.toTransferObject(productResponse));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) throws RecordNotFoundException {
        productService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    public ResponseEntity<ProductTO> update(@RequestBody ProductTO productTO) throws RecordNotFoundException {
        Product product = productConverter.toEntity(productTO);
        Product productResponse = productService.update(product);

        return ResponseEntity.ok(productConverter.toTransferObject(productResponse));
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<ProductTO>> list() {
        List<Product> list = productService.list();
        Iterable<ProductTO> productTOS = productConverter.toTransferObject(list);
//        productTOS.forEach(p -> p.setPort(port));
        return ResponseEntity.ok(productTOS);
    }

    @GetMapping("/findByDescription")
    public ResponseEntity<Iterable<ProductTO>> query(@RequestParam("description") String description) {
        Iterable<Product> list = productService.findByDescription(description);

        return ResponseEntity.ok(productConverter.toTransferObject(list));
    }

    @PostMapping("/checkAvailability")
    public ResponseEntity<CheckAvailabilityResponseTO> checkAvailability(
            @RequestBody CheckAvailabilityRequestTO checkAvailabilityRequestTO) {
        try {
            Product product = productService.checkAvailability(
                    checkAvailabilityRequestTO.getProductId(),
                    checkAvailabilityRequestTO.getQuantity());
            CheckAvailabilityResponseTO checkAvailabilityResponseTO = new CheckAvailabilityResponseTO(
                    product.getPrice(), true);

            return ResponseEntity.ok(checkAvailabilityResponseTO);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(new CheckAvailabilityResponseTO(new BigDecimal(0d), false));
    }
}
