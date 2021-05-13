package com.archsoft.client.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "Product", url = "${integration.product.url}")
public interface ProductClient {

    @PostMapping("/checkAvailability")
    ProductAvailabilityResponse checkAvailability(
            @RequestBody ProductAvailabilityRequest productAvailabilityRequest,
            @RequestHeader("Authorization") String token);
}
