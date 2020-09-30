package com.archsoft.symmetry;

public class Money {

    protected String currencyCode;

    protected double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money other = (Money) o;
        boolean currencyCodeEquals = (currencyCode == null && other.currencyCode == null)
                || (currencyCode != null && currencyCode.equals(other.currencyCode));

        return amount == other.amount && currencyCodeEquals;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
