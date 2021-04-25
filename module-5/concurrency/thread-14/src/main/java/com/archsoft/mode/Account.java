package com.archsoft.mode;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    @Getter
    private ReentrantLock lock = new ReentrantLock();

    @Getter @Setter
    private String number;

    @Getter @Setter
    private BigDecimal balance;

    public Account(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }
}
