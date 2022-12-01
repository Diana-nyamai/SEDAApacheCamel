package com.provisionresponse.routes;

import static org.apache.camel.LoggingLevel.INFO;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProvisionHttpRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:http")
                .log(INFO, this.log, "starting second route...")
                .to("https://fakerapi.it/api/v1/books?_quantity=1")
                .log("${body}");
    }
}
