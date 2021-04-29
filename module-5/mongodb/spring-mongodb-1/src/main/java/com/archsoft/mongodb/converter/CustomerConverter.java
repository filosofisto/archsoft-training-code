package com.archsoft.mongodb.converter;

import com.archsoft.mongodb.model.Customer;
import com.archsoft.mongodb.to.CustomerTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter extends Converter<Customer, CustomerTO> {
}
