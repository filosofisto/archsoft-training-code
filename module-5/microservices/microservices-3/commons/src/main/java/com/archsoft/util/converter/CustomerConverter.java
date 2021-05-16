package com.archsoft.util.converter;

import com.archsoft.model.customer.Customer;
import com.archsoft.to.customer.CustomerTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter extends Converter<Customer, CustomerTO> {
}
