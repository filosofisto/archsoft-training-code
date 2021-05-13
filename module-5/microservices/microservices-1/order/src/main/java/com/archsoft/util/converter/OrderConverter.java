package com.archsoft.util.converter;

import com.archsoft.model.Order;
import com.archsoft.model.OrderItem;
import com.archsoft.to.OrderItemTO;
import com.archsoft.to.OrderTO;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter extends Converter<Order, OrderTO> {

//    private final OrderItemConverter orderItemConverter;
//
//    public OrderConverter(OrderItemConverter orderItemConverter) {
//        this.orderItemConverter = orderItemConverter;
//    }
//
//    @Override
//    public OrderTO toTransferObject(Order entity) {
//        OrderTO orderTO = super.toTransferObject(entity);
//
//        entity.getItems().forEach(orderItem ->
//                orderTO.getItems().add(orderItemConverter.toTransferObject(orderItem)));
//
//        return orderTO;
//    }
}
