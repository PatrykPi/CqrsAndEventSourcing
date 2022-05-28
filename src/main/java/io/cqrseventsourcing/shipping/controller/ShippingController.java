package io.cqrseventsourcing.shipping.controller;

import io.cqrseventsourcing.order.dto.Order;
import io.cqrseventsourcing.shipping.ShippingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
class ShippingController {
    private final ShippingFacade service;

    @GetMapping("/all-orders")
    public CompletableFuture<List<Order>> findAllOrders() {
        return service.findAllOrders();
    }
}
