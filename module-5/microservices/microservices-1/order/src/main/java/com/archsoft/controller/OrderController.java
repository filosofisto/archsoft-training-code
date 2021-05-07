package com.archsoft.controller;

import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.model.Order;
import com.archsoft.service.OrderService;
import com.archsoft.to.OrderTO;
import com.archsoft.util.converter.OrderConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    private final OrderConverter orderConverter;

    public OrderController(OrderService orderService, OrderConverter orderConverter) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderTO> create(@RequestBody String customerId) throws CustomerInvalidException {
        Order order = orderService.create(customerId);
        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }


}
