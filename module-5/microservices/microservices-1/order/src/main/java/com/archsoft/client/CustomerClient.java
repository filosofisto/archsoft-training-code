package com.archsoft.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "Customer", url = "${integration.customer.url}")
public interface CustomerClient {

    @GetMapping("/validate/${customerId}")
    boolean isValid(@PathVariable("customerId") String customerId);
}
