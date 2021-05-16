package com.archsoft.service;

import com.archsoft.client.product.AddStockRequest;
import com.archsoft.client.product.ProductAvailabilityRequest;
import com.archsoft.client.product.ProductAvailabilityResponse;
import com.archsoft.config.KafkaConsumerConfig;
import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.exception.ProductNotAvailable;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.order.Order;
import com.archsoft.model.order.Status;
import com.archsoft.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    public OrderService(OrderRepository orderRepository,
                        CustomerService customerService,
                        ProductService productService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
    }

    public Order create(String customerId, String token) throws CustomerInvalidException {
        if (!customerService.isValid(customerId, token)) {
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

    public Order read(String orderId) throws RecordNotFoundException {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));
    }

    public Order addProduct(String orderId, String productId, Integer quantity, String token)
            throws RecordNotFoundException, ProductNotAvailable {
        ProductAvailabilityResponse productAvailabilityResponse = productService.checkAvailability(
                new ProductAvailabilityRequest(productId, quantity), token);

        if (!productAvailabilityResponse.isAvailable()) {
            throw new ProductNotAvailable(productId);
        }

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));

        // TODO: Desconto?
        Integer discount = 0;

        order.addItem(productId, quantity, productAvailabilityResponse.getPrice(), discount);
        return orderRepository.save(order);
    }

    public Order cancel(String orderId, String token) throws RecordNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));
        order.setStatus(Status.CANCELED.name());

        order.getItems().forEach(orderItem -> productService.addStock(
                new AddStockRequest(orderItem.getProductId(), orderItem.getQuantity()), token));

        return orderRepository.save(order);
    }

    public Order removeProduct(String orderId, String productId, String token) throws RecordNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));

        int sum = order.getItems().stream()
                .filter(orderItem -> orderItem.getProductId().equals(productId))
                .mapToInt(orderItem -> orderItem.getQuantity())
                .sum();

        if (sum > 0) {
            productService.addStock(new AddStockRequest(productId, sum), token);
        }

        order.removeProduct(productId);

        return orderRepository.save(order);
    }

    @KafkaListener(topics = "${kafka.product.topic}", groupId = KafkaConsumerConfig.GROUP)
    public void productListener(String message) {
        log.info("ProductListener received message: {}", message);

//        Product product = JSONUtil.toObject(message)
    }
}
