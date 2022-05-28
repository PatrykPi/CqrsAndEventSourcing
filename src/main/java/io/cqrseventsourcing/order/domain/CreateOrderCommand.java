package io.cqrseventsourcing.order.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
class CreateOrderCommand {
    @TargetAggregateIdentifier
    private final String orderId;
}
