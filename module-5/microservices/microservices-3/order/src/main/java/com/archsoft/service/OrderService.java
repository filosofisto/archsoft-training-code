package com.archsoft.service;

import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.exception.ProductNotAvailable;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.order.Order;
import com.archsoft.model.order.OrderItem;
import com.archsoft.model.order.Status;
import com.archsoft.model.product.Product;
import com.archsoft.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    private final MessageBrokerService messageBrokerService;

    public OrderService(OrderRepository orderRepository,
                        CustomerService customerService,
                        ProductService productService,
                        MessageBrokerService messageBrokerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.messageBrokerService = messageBrokerService;
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

    public Order addProduct(String orderId, String productId, Integer quantity)
            throws RecordNotFoundException, ProductNotAvailable, IOException {
        //--------------------------------------------------------------------
        // Check availability
        //--------------------------------------------------------------------
        Product product = productService.readByOriginalId(productId);

        int stock = Optional.ofNullable(product.getAttributes().get("stock"))
                .map(Integer::parseInt)
                .orElse(0);
        if (stock < quantity) {
            throw new ProductNotAvailable(productId);
        }
        //----------------------------------------------------------------------

        // Update Order
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));

        // TODO: Desconto?
        Integer discount = 0;

        order.addItem(product.getId(), quantity, product.getPrice(), discount);
        Order orderUpdated = orderRepository.save(order);

        // Send event to Kafka
        messageBrokerService.sendAddProduct(productId, quantity);

        return orderUpdated;
    }

    public Order cancel(String orderId) throws RecordNotFoundException, IOException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));
        order.setStatus(Status.CANCELED.name());

        for (OrderItem orderItem: order.getItems()) {
            Product product = productService.read(orderItem.getProductId());
            messageBrokerService.sendAddProduct(product.getOriginalId(), -orderItem.getQuantity());
        }

        return orderRepository.save(order);
    }

    public Order removeProduct(String orderId, String productId)
            throws RecordNotFoundException, IOException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RecordNotFoundException(orderId));

        Product product = productService.read(productId);

        int sum = order.getItems().stream()
                .filter(orderItem -> orderItem.getProductId().equals(product.getId()))
                .mapToInt(orderItem -> orderItem.getQuantity())
                .sum();

        if (sum > 0) {
            messageBrokerService.sendAddProduct(product.getOriginalId(), -sum);
        }

        order.removeProduct(product.getId());

        return orderRepository.save(order);
    }
}
