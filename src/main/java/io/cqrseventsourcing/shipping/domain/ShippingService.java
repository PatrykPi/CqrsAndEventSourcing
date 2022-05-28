package io.cqrseventsourcing.shipping.domain;

import io.cqrseventsourcing.order.dto.Order;
import io.cqrseventsourcing.shipping.ShippingFacade;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
class ShippingService implements ShippingFacade {
    private final QueryGateway queryGateway;

    @Override
    public CompletableFuture<List<Order>> findAllOrders() {
        return queryGateway.query(new FindAllShippedProductsQuery(), ResponseTypes.multipleInstancesOf(Order.class));
    }
}
