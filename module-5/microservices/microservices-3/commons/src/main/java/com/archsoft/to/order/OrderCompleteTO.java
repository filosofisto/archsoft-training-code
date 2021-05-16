package com.archsoft.to.order;

import com.archsoft.to.customer.CustomerTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderCompleteTO {

    private String id;
    private LocalDateTime dateTime;
    private String customerId;
    private BigDecimal total;
    private BigDecimal totalNet;
    private String status;
    private String paymentId;
    private Integer percent;
    private List<OrderItemTO> items;
    private CustomerTO customer;
}
