package io.cqrseventsourcing.order.domain;

import io.cqrseventsourcing.order.OrderFacade;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OrderConfiguration {
    @Bean
    OrderFacade orderService(final CommandGateway commandGateway) {
        return new OrderService(commandGateway);
    }
}
