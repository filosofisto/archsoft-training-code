package com.archsoft.client;

import com.archsoft.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ManningClient {

    private static final Logger log = LoggerFactory.getLogger(ManningClient.class);

    @Value("${manning.url}")
    private String url;

    private RestTemplate restTemplate;

    public ManningClient() {
        this.restTemplate = new RestTemplate();
    }

    public Product getProduct(String code) {
        log.info("Checking Manning price for product {}...", code);
        Product result = restTemplate.getForObject(url + "/" + code, Product.class);
        log.info("Manning Price: {}", result.getPrice());

        return result;
    }
}
