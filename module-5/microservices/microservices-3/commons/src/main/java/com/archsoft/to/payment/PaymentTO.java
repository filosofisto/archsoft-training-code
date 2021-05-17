package com.archsoft.to.payment;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentTO {

    private String id;
    private String originalId;
    private LocalDateTime dateTime;
    private String orderId;
    private String creditCardNumber;
    private String nameOnCard;
    private String expiryDate;
    private String securityCode;
    private BigDecimal value;
    private String status;
}
