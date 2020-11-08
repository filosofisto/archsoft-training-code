package com.archsoft.entity;

public class Cart {

    protected Integer operationCount; // transient state

    public Cart() {
        this.operationCount = 0;
    }

    public void incrementOperationCount() {
        operationCount++;
    }

    public Integer getOperationCount() {
        return operationCount;
    }

}
