package io.cqrseventsourcing.shipping;

import io.cqrseventsourcing.order.dto.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface ShippingFacade {
    CompletableFuture<List<Order>> findAllOrders();
}
