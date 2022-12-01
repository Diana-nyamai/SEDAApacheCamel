package com.marshal;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.INFO;


@Component
public class HttpRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        JacksonDataFormat addressesDataFormat = new JacksonDataFormat(Adresses.class);
        from("direct:http")
                .log(INFO, this.log, "This is the second message")
                .to("https://fakerapi.it/api/v1/addresses?_quantity=1")
                .unmarshal(addressesDataFormat)
                .log(INFO, this.log, "Deserialised json: ${body}")
                .marshal(addressesDataFormat)
                .log(INFO, this.log,"Serialised data: ${body}");
    }
}
