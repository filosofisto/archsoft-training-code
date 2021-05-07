package com.archsoft.to;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderTO {

    private String id;
    private LocalDateTime dateTime;
    private String customerId;
    private BigDecimal total;
    private BigDecimal totalNet;
    private String status;
    private String paymentId;
    private Integer percent;
}
