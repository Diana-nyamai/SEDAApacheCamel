package com.safaricom;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;

public class ArrayListAgreggationStrategy extends AbstractListAggregationStrategy {
    @Override
    public String getValue(Exchange exchange) {
        return exchange.getIn()
                .getBody(String.class);
    }
}
