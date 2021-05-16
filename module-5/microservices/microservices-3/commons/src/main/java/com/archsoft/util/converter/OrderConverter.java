package com.archsoft.util.converter;

import com.archsoft.model.order.Order;
import com.archsoft.to.order.OrderTO;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter extends Converter<Order, OrderTO> {

}
