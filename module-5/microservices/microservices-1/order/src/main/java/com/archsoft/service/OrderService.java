package com.archsoft.service;

import com.archsoft.client.CustomerClient;
import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Order;
import com.archsoft.model.Status;
import com.archsoft.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerClient customerClient;

    public OrderService(OrderRepository orderRepository, CustomerClient customerClient) {
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
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

    public Order cancel(String orderId) throws RecordNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));
        order.setStatus(Status.CANCELED.name());

        return orderRepository.save(order);
    }
}
