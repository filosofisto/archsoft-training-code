package com.archsoft.mongodb.graphql;

import com.archsoft.mongodb.converter.ProductConverter;
import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.service.ProductService;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class ProductDataFetchers {

    private final ProductService productService;

    private final ProductConverter productConverter;

    public ProductDataFetchers(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    public DataFetcher readProductDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return productService.find(id);
        };
    }

    public DataFetcher listProductsDataFetcher() {
        return dataFetchingEnvironment -> productService.list();
    }

    public DataFetcher createProduct() {
        return dataFetchingEnvironment -> {
            Map<String, Object> map = dataFetchingEnvironment.getArgument("input");
            Product product = productConverter.fromMapToEntity(map);

            Product productSaved = productService.create(product);

            return productConverter.toTransferObject(productSaved);
        };
    }

    public DataFetcher updateProduct() {
        return dataFetchingEnvironment -> {
            Map<String, Object> map = dataFetchingEnvironment.getArgument("input");
            Product product = productConverter.fromMapToEntity(map);

            Product productSaved = productService.update(product);

            return productConverter.toTransferObject(productSaved);
        };
    }

    public DataFetcher changeProductPrice() {
        return dataFetchingEnvironment -> {
            Map<String, Object> map = dataFetchingEnvironment.getArgument("input");
            String id = Optional.ofNullable(map.get("id"))
                    .map(Objects::toString)
                    .orElse(null);
            BigDecimal price = new BigDecimal(Optional.ofNullable(map.get("price"))
                    .map(x -> (Double) x)
                    .orElse(0d));

            return productService.changePrice(id, price);
        };
    }

    public DataFetcher deleteProduct() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");

            Product productDeleted = productService.delete(id);

            return productConverter.toTransferObject(productDeleted);
        };
    }
}
