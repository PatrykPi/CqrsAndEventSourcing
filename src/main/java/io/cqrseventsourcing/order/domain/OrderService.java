package io.cqrseventsourcing.order.domain;

import io.cqrseventsourcing.order.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
class OrderService implements OrderFacade {
    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<Void> shipOrder() {
        final String orderId = UUID.randomUUID().toString();
        return commandGateway.send(new CreateOrderCommand(orderId))
                .thenCompose(result -> commandGateway.send(new AddProductCommand(orderId, "Deluxe Chair")))
                .thenCompose(result -> commandGateway.send(new ConfirmOrderCommand(orderId)))
                .thenCompose(result -> commandGateway.send(new ShipOrderCommand(orderId)));
    }

    @Override
    public CompletableFuture<Void> shipUnconfirmedOrder() {
        final String orderId = UUID.randomUUID().toString();
        return commandGateway.send(new CreateOrderCommand(orderId))
                .thenCompose(result -> commandGateway.send(new AddProductCommand(orderId, "Deluxe Chair")))
                .thenCompose(result -> commandGateway.send(new ShipOrderCommand(orderId)));
    }

    @Override
    public CompletableFuture<String> createOrder() {
        return createOrder(UUID.randomUUID().toString());
    }

    @Override
    public CompletableFuture<String> createOrder(final String orderId) {
        return commandGateway.send(new CreateOrderCommand(orderId));
    }

    @Override
    public CompletableFuture<Void> addProduct(final String orderId, final String productId) {
        return commandGateway.send(new AddProductCommand(orderId, productId));
    }

    @Override
    public CompletableFuture<Void> confirmOrder(final String orderId) {
        return commandGateway.send(new ConfirmOrderCommand(orderId));
    }

    @Override
    public CompletableFuture<Void> shipOrder(final String orderId) {
        return commandGateway.send(new ShipOrderCommand(orderId));
    }
}
