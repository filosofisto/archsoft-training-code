package com.archsoft.symmetry;

import com.archsoft.consistence.Device;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoneyVoucherTest {

    @Test
    public void voucherIsNotCash() {
        Money cash = new Money();
        cash.setAmount(100);
        cash.setCurrencyCode("US");

        Voucher voucher = new Voucher();
        voucher.setAmount(100);
        voucher.setCurrencyCode("US");
        voucher.setStore("Amazon");

        // false -> expected
        assertNotEquals(cash, voucher);
    }

    @Test
    public void cashShouldNotBeVoucher() {
        Money cash = new Money();
        cash.setAmount(100);
        cash.setCurrencyCode("US");

        Voucher voucher = new Voucher();
        voucher.setAmount(100);
        voucher.setCurrencyCode("US");
        voucher.setStore("Amazon");

        // false -> expected => error - money is not a voucher
        assertNotEquals(voucher, cash);
    }

    @Test
    public void hashCodeInconsistence() {
        Map<Device, String> map = new HashMap<>();

        map.put(new Device("12345", "iPhone 7"), "Great cellphone");
        map.put(new Device("12367", "Android X"), "Very good cellphone");
        map.put(new Device("34355", "Xingling 11"), "Good cellphone");

        assertNotNull(map.get(new Device("12345", "iPhone 7")));
    }
}
