package com.archsoft.util.converter;

import com.archsoft.model.order.OrderItem;
import com.archsoft.to.order.OrderItemTO;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter extends Converter<OrderItem, OrderItemTO> {
}
