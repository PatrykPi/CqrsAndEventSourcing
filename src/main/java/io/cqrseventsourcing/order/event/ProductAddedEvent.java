package io.cqrseventsourcing.order.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class ProductAddedEvent {
    private final String orderId;
    private final String productId;
}
