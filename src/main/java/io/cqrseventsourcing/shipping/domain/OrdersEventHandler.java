package io.cqrseventsourcing.shipping.domain;

import io.cqrseventsourcing.order.dto.Order;
import io.cqrseventsourcing.order.event.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
class OrdersEventHandler {

    private final Map<String, Order> orders = new HashMap<>();

    @EventHandler
    public void on(final OrderCreatedEvent event) {
        final String orderId = event.getOrderId();
        orders.put(orderId, new Order(orderId));
    }

    @QueryHandler
    public List<Order> handle(final FindAllShippedProductsQuery query) {
        return new ArrayList<>(orders.values());
    }
}
