package com.archsoft.util.converter;

import com.archsoft.model.payment.Payment;
import com.archsoft.to.payment.PaymentTO;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter extends Converter<Payment, PaymentTO> {

}
