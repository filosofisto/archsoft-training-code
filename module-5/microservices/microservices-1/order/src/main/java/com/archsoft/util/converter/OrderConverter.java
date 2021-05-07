package com.archsoft.util.converter;

import com.archsoft.model.Order;
import com.archsoft.to.OrderTO;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter extends Converter<Order, OrderTO> {
}
