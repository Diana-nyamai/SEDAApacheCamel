package com.Books;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.INFO;

@Component
public class HttpBookRoute extends RouteBuilder {
    JacksonDataFormat booksdataformat = new JacksonDataFormat(Books.class);
    @Override
    public void configure() throws Exception {
        from("direct:http")
                .log(INFO, this.log, "second message")
                .to("https://fakerapi.it/api/v1/books?_quantity=1")
                .unmarshal(booksdataformat)
                .log(INFO, this.log, "Deserialised json ${body}")
                .marshal(booksdataformat)
                .log(INFO, this.log, "serialised data ${body}");
    }
}
