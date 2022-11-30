package com.marshal;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.INFO;

@Component
public class FirstRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:firsttimer?period=5000000")
                .routeId("main route")
                .log(INFO, this.log, "This is the first message")
                .to("direct:http");


    }
}
