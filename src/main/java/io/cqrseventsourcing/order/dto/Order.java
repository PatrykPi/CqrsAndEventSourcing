package io.cqrseventsourcing.order.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Order {
    private final String orderId;
    private OrderStatus orderStatus;

    public Order(final String orderId) {
        this.orderId = orderId;
        orderStatus = OrderStatus.CREATED;
    }

    public void setOrderConfirmed() {
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    public void setOrderShipped() {
        this.orderStatus = OrderStatus.SHIPPED;
    }

    public enum OrderStatus {
        CREATED, CONFIRMED, SHIPPED
    }
}
