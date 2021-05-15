package com.archsoft.util.converter;

import com.archsoft.model.Customer;
import com.archsoft.to.CustomerTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter extends Converter<Customer, CustomerTO> {
}
