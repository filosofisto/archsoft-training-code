package com.archsoft.controller;

import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.Order;
import com.archsoft.service.OrderService;
import com.archsoft.to.OrderTO;
import com.archsoft.util.converter.OrderConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    private final OrderConverter orderConverter;

    public OrderController(OrderService orderService, OrderConverter orderConverter) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderTO> create(@RequestBody String customerId,
                                          @RequestHeader("Authorization") String token) throws CustomerInvalidException {
        Order order = orderService.create(customerId, token);
        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }

    @PutMapping("/cancel")
    public ResponseEntity<OrderTO> cancel(@RequestBody String orderId) throws RecordNotFoundException {
        Order order = orderService.cancel(orderId);
        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }


}
