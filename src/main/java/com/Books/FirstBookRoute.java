package com.Books;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.INFO;

@Component
public class FirstBookRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:timerroute?period=500000")
                .routeId("main route")
                .log(INFO, this.log, "First book message" )
                .to("direct:http");

    }
}
