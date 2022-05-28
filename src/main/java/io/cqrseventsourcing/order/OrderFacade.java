package io.cqrseventsourcing.order;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface OrderFacade {
    CompletableFuture<Void> shipOrder();

    CompletableFuture<Void> shipUnconfirmedOrder();

    CompletableFuture<String> createOrder();

    CompletableFuture<String> createOrder(final String orderId);

    CompletableFuture<Void> addProduct(final String orderId, final String productId);

    CompletableFuture<Void> confirmOrder(final String orderId);

    CompletableFuture<Void> shipOrder(final String orderId);
}
