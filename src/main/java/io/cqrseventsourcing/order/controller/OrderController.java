package io.cqrseventsourcing.order.controller;

import io.cqrseventsourcing.order.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
class OrderController {
    private final OrderFacade service;

    @PostMapping("/ship-order")
    public CompletableFuture<Void> shipOrder() {
        return service.shipOrder();
    }

    @PostMapping("/ship-unconfirmed-order")
    public CompletableFuture<Void> shipUnconfirmedOrder() {
        return service.shipUnconfirmedOrder();
    }

    @PostMapping("/order")
    public CompletableFuture<String> createOrder() {
        return service.createOrder();
    }

    @PostMapping("/order/{order-id}")
    public CompletableFuture<String> createOrder(@PathVariable("order-id") final String orderId) {
        return service.createOrder(orderId);
    }

    @PostMapping("/order/{order-id}/product/{product-id}")
    public CompletableFuture<Void> addProduct(@PathVariable("order-id") final String orderId,
                                              @PathVariable("product-id") final String productId) {
        return service.addProduct(orderId, productId);
    }

    @PostMapping("/order/{order-id}/confirm")
    public CompletableFuture<Void> confirmOrder(@PathVariable("order-id") final String orderId) {
        return service.confirmOrder(orderId);
    }

    @PostMapping("/order/{order-id}/ship")
    public CompletableFuture<Void> shipOrder(@PathVariable("order-id") final String orderId) {
        return service.shipOrder(orderId);
    }
}
