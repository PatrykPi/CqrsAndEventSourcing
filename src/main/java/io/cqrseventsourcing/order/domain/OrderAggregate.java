package io.cqrseventsourcing.order.domain;

import io.cqrseventsourcing.order.event.OrderConfirmedEvent;
import io.cqrseventsourcing.order.event.OrderCreatedEvent;
import io.cqrseventsourcing.order.event.OrderShippedEvent;
import io.cqrseventsourcing.order.event.ProductAddedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private boolean orderConfirmed;

    @CommandHandler
    OrderAggregate(final CreateOrderCommand command) {
        apply(new OrderCreatedEvent(command.getOrderId()));
    }

    @EventSourcingHandler
    void on(final OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        orderConfirmed = false;
    }

    @CommandHandler
    void handle(AddProductCommand command) {
        if (orderConfirmed) {
            throw new RuntimeException(orderId);
        }

        final String productId = command.getProductId();
        apply(new ProductAddedEvent(orderId, productId));
    }

    @CommandHandler
    void handle(ConfirmOrderCommand command) {
        if (orderConfirmed) {
            return;
        }
        apply(new OrderConfirmedEvent(orderId));
    }

    @CommandHandler
    void handle(ShipOrderCommand command) {
        if (!orderConfirmed) {
            throw new RuntimeException();
        }
        apply(new OrderShippedEvent(orderId));
    }

    @EventSourcingHandler
    void on(OrderConfirmedEvent event) {
        orderConfirmed = true;
    }
}
