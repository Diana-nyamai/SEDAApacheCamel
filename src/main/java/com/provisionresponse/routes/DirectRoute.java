package com.provisionresponse.routes;

import static org.apache.camel.LoggingLevel.INFO;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DirectRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:provisionTimer?period=50000")
                .log(INFO, this.log, "Starting timer....")
                .to("direct:http");
    }
}
