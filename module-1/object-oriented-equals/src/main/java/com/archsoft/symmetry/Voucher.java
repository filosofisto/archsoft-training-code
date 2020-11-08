package com.archsoft.symmetry;

public class Voucher extends Money {

    private String store;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Voucher)) return false;

        Voucher other = (Voucher) o;

        boolean currencyCodeEquals = (currencyCode == null && other.currencyCode == null)
                || (currencyCode != null && currencyCode.equals(other.currencyCode));
        boolean storeEquals = (store == null && other.store == null)
                || (store != null && store.equals(other.store));

        return amount == other.amount && currencyCodeEquals && storeEquals;
    }
}
