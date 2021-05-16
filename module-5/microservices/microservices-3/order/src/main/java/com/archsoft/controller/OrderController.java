package com.archsoft.controller;

import com.archsoft.exception.CustomerInvalidException;
import com.archsoft.exception.ProductNotAvailable;
import com.archsoft.exception.RecordNotFoundException;
import com.archsoft.model.order.Order;
import com.archsoft.model.product.Product;
import com.archsoft.service.CustomerService;
import com.archsoft.service.OrderService;
import com.archsoft.service.ProductService;
import com.archsoft.to.AddProductRequestTO;
import com.archsoft.to.RemoveProductRequestTO;
import com.archsoft.to.customer.CustomerTO;
import com.archsoft.to.order.OrderTO;
import com.archsoft.util.converter.OrderConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    private final OrderService orderService;

    private final OrderConverter orderConverter;

    private final CustomerService customerService;

    private final ProductService productService;

    public OrderController(OrderService orderService, OrderConverter orderConverter,
                           CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
        this.customerService = customerService;
        this.productService = productService;
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
            Product product = null;

            try {
                product = productService.readByOriginalId(orderItemTO.getProductId());

                orderItemTO.setName(product.getName());
                orderItemTO.setDescription(product.getDescription());
                orderItemTO.setCategory(product.getCategory());
            } catch (RecordNotFoundException e) {
                e.printStackTrace();
            }
        });

        CustomerTO customerTO = customerService.read(order.getCustomerId(), token);

        Map<String, Object> result = new HashMap<>();
        result.put("order", orderTO);
        result.put("customer", customerTO);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/cancel")
    public ResponseEntity<OrderTO> cancel(@RequestBody String orderId)
            throws RecordNotFoundException, IOException {
        Order order = orderService.cancel(orderId);
        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<OrderTO> addProduct(@RequestBody AddProductRequestTO addProductRequestTO)
            throws RecordNotFoundException, ProductNotAvailable, IOException {
        Order order = orderService.addProduct(
                addProductRequestTO.getOrderId(),
                addProductRequestTO.getProductId(),
                addProductRequestTO.getQuantity()
        );

        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }

    @PostMapping("/removeProduct")
    public ResponseEntity<OrderTO> removeProduct(@RequestBody RemoveProductRequestTO removeProductRequestTO)
            throws RecordNotFoundException, IOException {
        Order order = orderService.removeProduct(
                removeProductRequestTO.getOrderId(),
                removeProductRequestTO.getProductId());

        OrderTO orderTO = orderConverter.toTransferObject(order);

        return ResponseEntity.ok(orderTO);
    }

}
