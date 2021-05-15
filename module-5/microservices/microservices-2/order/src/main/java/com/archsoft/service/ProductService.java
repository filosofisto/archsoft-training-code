package com.archsoft.service;

import com.archsoft.client.product.AddStockRequest;
import com.archsoft.client.product.ProductAvailabilityRequest;
import com.archsoft.client.product.ProductAvailabilityResponse;
import com.archsoft.client.product.ProductClient;
import com.archsoft.model.StockAction;
import com.archsoft.repository.StockActionRepository;
import com.archsoft.to.ProductTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    private final ProductClient productClient;

    private final StockActionRepository stockActionRepository;

    public ProductService(ProductClient productClient, StockActionRepository stockActionRepository) {
        this.productClient = productClient;
        this.stockActionRepository = stockActionRepository;
    }

    @HystrixCommand(fallbackMethod = "checkAvailabilityFallback")
    public ProductAvailabilityResponse checkAvailability(
            ProductAvailabilityRequest productAvailabilityRequest,
            String token) {
        return productClient.checkAvailability(productAvailabilityRequest, token);
    }

    public ProductAvailabilityResponse checkAvailabilityFallback(ProductAvailabilityRequest productAvailabilityRequest,
                                                                 String token) {
        return new ProductAvailabilityResponse(new BigDecimal(0d), false);
    }

    @HystrixCommand(fallbackMethod = "addStockFallback")
    public void addStock(AddStockRequest addStockRequest, String token) {
        productClient.addStock(addStockRequest, token);
    }

    public void addStockFallback(AddStockRequest addStockRequest, String token) {
        stockActionRepository.save(new StockAction(addStockRequest.getProductId(), addStockRequest.getQuantity()));
    }

    @HystrixCommand(fallbackMethod = "readFallback")
    public ProductTO read(String productId, String token) {
        return productClient.read(productId, token);
    }

    public ProductTO readFallback(String productId, String token) {
        return new ProductTO(
                productId,
                "???",
                "???",
                "???",
                new BigDecimal(0d),
                null);
    }
}
