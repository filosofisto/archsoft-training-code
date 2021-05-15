package com.archsoft.service;

import com.archsoft.client.customer.CustomerClient;
import com.archsoft.to.CustomerTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerClient customerClient;

    public CustomerService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public boolean isValid(String customerId, String token) {
        return customerClient.isValid(customerId, token);
    }

    @HystrixCommand(fallbackMethod = "readFallback")
    public CustomerTO read(String customerId, String token) {
        return customerClient.read(customerId, token);
    }

    public CustomerTO readFallback(String customerId, String token) {
        CustomerTO customerTO = new CustomerTO();

        customerTO.setId(customerId);
        customerTO.setName("???");
        customerTO.setEmail("???");

        return customerTO;
    }
}
