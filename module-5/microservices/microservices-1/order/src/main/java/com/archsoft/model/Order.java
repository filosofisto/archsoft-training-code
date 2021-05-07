package com.archsoft.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order extends AbstractDocument {

    private LocalDateTime dateTime;
    private String customerId;
    private BigDecimal total;
    private BigDecimal totalNet;
    private String status;
    private String paymentId;
    private Integer percent;
    private List<OrderItem> items;
}
