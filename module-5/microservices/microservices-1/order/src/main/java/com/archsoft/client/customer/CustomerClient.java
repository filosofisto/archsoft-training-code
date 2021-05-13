package com.archsoft.client.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "Customer", url = "${integration.customer.url}")
public interface CustomerClient {

    @GetMapping("/validate/{customerId}")
    boolean isValid(@PathVariable("customerId") String customerId, @RequestHeader("Authorization") String token);
}
