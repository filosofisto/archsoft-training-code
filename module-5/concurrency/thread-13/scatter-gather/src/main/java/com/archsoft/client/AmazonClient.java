package com.archsoft.client;

import com.archsoft.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AmazonClient {

    private static final Logger log = LoggerFactory.getLogger(AmazonClient.class);

    @Value("${amazon.url}")
    private String url;

    private RestTemplate restTemplate;

    public AmazonClient() {
        this.restTemplate = new RestTemplate();
    }

    public Product getProduct(String code) {
        log.info("Checking Amazon price for product {}...", code);
        Product result = restTemplate.getForObject(url+"/"+code, Product.class);
        log.info("Amazon Price: {}", result.getPrice());

        return result;
    }
}
