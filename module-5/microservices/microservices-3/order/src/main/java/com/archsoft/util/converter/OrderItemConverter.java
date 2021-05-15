package com.archsoft.util.converter;

import com.archsoft.model.OrderItem;
import com.archsoft.to.OrderItemTO;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter extends Converter<OrderItem, OrderItemTO> {
}
