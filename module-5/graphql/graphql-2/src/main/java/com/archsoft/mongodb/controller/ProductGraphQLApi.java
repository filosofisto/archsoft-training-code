package com.archsoft.mongodb.controller;

import com.archsoft.mongodb.converter.ProductConverter;
import com.archsoft.mongodb.exception.RecordNotFoundException;
import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.service.ProductService;
import com.archsoft.mongodb.to.ProductTO;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@GraphQLApi
public class ProductGraphQLApi {

    private final ProductService productService;

    private final ProductConverter productConverter;

    public ProductGraphQLApi(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @GraphQLQuery(name = "listProducts")
    public Iterable<ProductTO> list() {
        List<Product> productList = productService.list();
        Iterable<ProductTO> productTOList = productConverter.toTransferObject(productList);

        return productTOList;
    }

    @GraphQLQuery(name = "readProduct")
    public ProductTO read(@GraphQLArgument(name = "id") String id) throws RecordNotFoundException {
        Product product = productService.find(id);
        return productConverter.toTransferObject(product);
    }

    @GraphQLMutation(name = "createProduct")
    public ProductTO create(@GraphQLArgument(name = "input") ProductTO productTO) {
        Product productToSave = productConverter.toEntity(productTO);
        Product productSaved = productService.create(productToSave);

        return productConverter.toTransferObject(productSaved);
    }

    @GraphQLMutation(name = "updateProduct")
    public ProductTO update(@GraphQLArgument(name = "input") ProductTO productTO) throws RecordNotFoundException {
        Product productToSave = productConverter.toEntity(productTO);
        Product productSaved = productService.update(productToSave);

        return productConverter.toTransferObject(productSaved);
    }

    @GraphQLMutation(name = "deleteProduct")
    public ProductTO delete(@GraphQLArgument(name = "id") String id) throws RecordNotFoundException {
        Product product = productService.delete(id);

        return productConverter.toTransferObject(product);
    }
}
