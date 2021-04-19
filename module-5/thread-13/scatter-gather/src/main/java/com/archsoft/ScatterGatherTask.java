package com.archsoft;

import com.archsoft.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static java.lang.System.out;

@Component
public class ScatterGatherTask implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ScatterGatherTask.class);

    private final PriceScatterGather priceScatterGather;

    public ScatterGatherTask(PriceScatterGather priceScatterGather) {
        this.priceScatterGather = priceScatterGather;
    }

    @Override
    public void run(String... args) {
        try {
            Set<BigDecimal> prices = priceScatterGather.getPrices("12345");

            double minPrice = prices.stream()
                    .mapToDouble(x -> x.doubleValue())
                    .min()
                    .orElseThrow(RuntimeException::new);

            out.printf("Min Price: %f\n", minPrice);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        } catch (ExecutionException e) {
            log.error(e.getMessage(), e);
        }
    }
}
