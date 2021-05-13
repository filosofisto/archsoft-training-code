package com.archsoft.service;

import com.archsoft.client.customer.CustomerClient;
import com.archsoft.client.product.ProductClient;
import com.archsoft.client.product.ProductAvailabilityRequest;
import com.archsoft.client.product.ProductAvailabilityResponse;
import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.exception.ProductNotAvailable;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Order;
import com.archsoft.model.Status;
import com.archsoft.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository,
                        CustomerClient customerClient,
                        ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    public Order create(String customerId, String token) throws CustomerInvalidException {
        if (!customerClient.isValid(customerId, token)) {
            throw new CustomerInvalidException(customerId);
        }

        Order order = new Order();

        order.setDateTime(LocalDateTime.now());
        order.setCustomerId(customerId);
        order.setStatus(Status.OPENED.name());
        order.setTotal(new BigDecimal(0d));
        order.setTotalNet(new BigDecimal(0d));
        order.setPercent(0);

        return orderRepository.insert(order);
    }

    public Order addProduct(String orderId, String productId, Integer quantity, String token)
            throws RecordNotFoundException, ProductNotAvailable {
        ProductAvailabilityResponse productAvailabilityResponse = productClient.checkAvailability(
                new ProductAvailabilityRequest(productId, quantity), token);

        if (!productAvailabilityResponse.isAvailable()) {
            throw new ProductNotAvailable(productId);
        }

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));

        // TODO: Disconto?
        Integer discount = 0;

        order.addItem(productId, quantity, productAvailabilityResponse.getPrice(), discount);
        return orderRepository.save(order);
    }

    public Order cancel(String orderId) throws RecordNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));
        order.setStatus(Status.CANCELED.name());

        return orderRepository.save(order);
    }
}
