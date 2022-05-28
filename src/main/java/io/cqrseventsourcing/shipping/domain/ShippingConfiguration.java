package io.cqrseventsourcing.shipping.domain;

import io.cqrseventsourcing.shipping.ShippingFacade;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ShippingConfiguration {

    @Bean
    ShippingFacade shippingService(final QueryGateway queryGateway) {
        return new ShippingService(queryGateway);
    }
}
