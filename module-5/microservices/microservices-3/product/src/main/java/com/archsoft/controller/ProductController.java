package com.archsoft.controller;

import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.product.Product;
import com.archsoft.service.ProductService;
import com.archsoft.to.product.ProductTO;
import com.archsoft.util.converter.DirectionConverter;
import com.archsoft.util.converter.ProductConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
//@CrossOrigin
public class ProductController {

    private final ProductService productService;

    private final ProductConverter productConverter;

    private final PagedResourcesAssembler<ProductTO> assembler;

    public ProductController(ProductService productService, ProductConverter productConverter, PagedResourcesAssembler<ProductTO> assembler) {
        this.productService = productService;
        this.productConverter = productConverter;
        this.assembler = assembler;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductTO> create(@RequestBody ProductTO productTO) throws IOException {
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
    public ResponseEntity delete(@PathVariable("id") String id) throws RecordNotFoundException, IOException {
        productService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    public ResponseEntity<ProductTO> update(@RequestBody ProductTO productTO) throws RecordNotFoundException, IOException {
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

    @GetMapping("/listPaged")
    public ResponseEntity<PagedModel<EntityModel<ProductTO>>> listPaged(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            @RequestParam(value = "sortBy", defaultValue = "name") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, DirectionConverter.from(direction), sortBy);
        Page<ProductTO> pageResult = productConverter.toTransferObject(productService.findAll(pageable));

        PagedModel<EntityModel<ProductTO>> pagedModel = assembler.toModel(pageResult);

        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/findByDescription")
    public ResponseEntity<Iterable<ProductTO>> query(@RequestParam("description") String description) {
        Iterable<Product> list = productService.findByDescription(description);

        return ResponseEntity.ok(productConverter.toTransferObject(list));
    }
}
