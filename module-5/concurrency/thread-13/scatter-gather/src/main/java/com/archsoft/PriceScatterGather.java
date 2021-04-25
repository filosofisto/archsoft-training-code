package com.archsoft;

import com.archsoft.client.AmazonClient;
import com.archsoft.client.BadBooksClient;
import com.archsoft.client.ManningClient;
import com.archsoft.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Component
public class PriceScatterGather {

    private final AmazonClient amazonClient;

    private final ManningClient manningClient;

    private final BadBooksClient badBooksClient;

    public PriceScatterGather(AmazonClient amazonClient, ManningClient manningClient, BadBooksClient badBooksClient) {
        this.amazonClient = amazonClient;
        this.manningClient = manningClient;
        this.badBooksClient = badBooksClient;
    }

    public Set<BigDecimal> getPrices(String code) throws InterruptedException, ExecutionException {
        Set<BigDecimal> result = new HashSet<>();

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Product> amazon = pool.submit(() -> amazonClient.getProduct(code));
        Future<Product> manning = pool.submit(() -> manningClient.getProduct(code));
        Future<Product> badbooks = pool.submit(() -> badBooksClient.getProduct(code));

        pool.awaitTermination(5, TimeUnit.SECONDS);

        if (amazon.isDone()) {
            result.add(amazon.get().getPrice());
        }
        if (manning.isDone()) {
            result.add(manning.get().getPrice());
        }
        if (badbooks.isDone()) {
            result.add(badbooks.get().getPrice());
        }

        pool.shutdownNow();

        return result;
    }
}
