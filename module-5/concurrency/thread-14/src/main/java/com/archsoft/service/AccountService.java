package com.archsoft.service;

import com.archsoft.exception.OperationException;
import com.archsoft.mode.Account;

import java.math.BigDecimal;

public interface AccountService {

    BigDecimal withdraw(Account account, BigDecimal value) throws OperationException;

    void transfer(Account accountSource, Account accountTarget, BigDecimal value) throws OperationException;
}
