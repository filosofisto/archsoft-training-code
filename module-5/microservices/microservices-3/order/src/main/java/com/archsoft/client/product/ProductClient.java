package com.archsoft.client.product;

import com.archsoft.to.ProductTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "Product", url = "${integration.product.url}")
public interface ProductClient {

    @PostMapping("/checkAvailability")
    ProductAvailabilityResponse checkAvailability(
            @RequestBody ProductAvailabilityRequest productAvailabilityRequest,
            @RequestHeader("Authorization") String token);

    @PostMapping("/addStock")
    void addStock(@RequestBody AddStockRequest addStockRequest,
                  @RequestHeader("Authorization") String token);

    @GetMapping("/read/{productId}")
    ProductTO read(@PathVariable("productId") String productId,
                   @RequestHeader("Authorization") String token);
}
