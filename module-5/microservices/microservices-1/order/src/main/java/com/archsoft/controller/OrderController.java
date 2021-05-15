package com.archsoft.controller;

import com.archsoft.client.customer.CustomerClient;
import com.archsoft.client.product.ProductClient;
import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.exception.ProductNotAvailable;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Order;
import com.archsoft.service.OrderService;
import com.archsoft.to.*;
import com.archsoft.util.converter.OrderConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    private final OrderService orderService;

    private final OrderConverter orderConverter;

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    public OrderController(OrderService orderService, OrderConverter orderConverter, CustomerClient customerClient, ProductClient productClient) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderTO> create(@RequestBody String customerId,
                                          @RequestHeader("Authorization") String token) throws CustomerInvalidException {
        Order order = orderService.create(customerId, token);
        OrderTO orderTO = orderConverter.toTransferObject(order);

        //TODO: 201
        return ResponseEntity.ok(orderTO);
    }

    @GetMapping("/read/{orderId}")
    public ResponseEntity<Map<String, Object>> read(@PathVariable("orderId") String orderId,
                                        @RequestHeader("Authorization") String token)
            throws RecordNotFoundException {
        Order order = orderService.read(orderId);
        OrderTO orderTO = orderConverter.toTransferObject(order);

        orderTO.getItems().forEach(orderItemTO -> {
            try {
                ProductTO productTO = productClient.read(orderItemTO.getProductId(), token);

                orderItemTO.setName(productTO.getName());
                orderItemTO.setDescription(productTO.getDescription());
                orderItemTO.setCategory(productTO.getCategory());
            } catch (Exception e) {
                orderItemTO.setName("???");
                orderItemTO.setDescription("???");
                orderItemTO.setCategory("???");
            }
        });

        CustomerTO customerTO = customerClient.read(order.getCustomerId(), token);

        Map<String, Object> result = new HashMap<>();
        result.put("order", orderTO);
        result.put("customer", customerTO);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/cancel")
    public ResponseEntity<OrderTO> cancel(@RequestBody String orderId,
                                          @RequestHeader("Authorization") String token) throws RecordNotFoundException {
        Order order = orderService.cancel(orderId, token);
        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<OrderTO> addProduct(@RequestBody AddProductRequestTO addProductRequestTO,
                                              @RequestHeader("Authorization") String token) throws RecordNotFoundException, ProductNotAvailable {
        Order order = orderService.addProduct(
                addProductRequestTO.getOrderId(),
                addProductRequestTO.getProductId(),
                addProductRequestTO.getQuantity(),
                token);

        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }

    @PostMapping("/removeProduct")
    public ResponseEntity<OrderTO> removeProduct(@RequestBody RemoveProductRequestTO removeProductRequestTO,
                                                 @RequestHeader("Authorization") String token) throws RecordNotFoundException, ProductNotAvailable {
        Order order = orderService.removeProduct(
                removeProductRequestTO.getOrderId(),
                removeProductRequestTO.getProductId(),
                token);

        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }

}
