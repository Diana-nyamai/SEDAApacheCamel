package com.Books.routes;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import static org.apache.camel.Exchange.HTTP_METHOD;
import static org.springframework.http.HttpMethod.POST;

@Slf4j
@Component
public class HttpPostRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:myposttimer?period=50000")
                .setHeader(HTTP_METHOD).constant(HttpMethod.GET)
                .log("Http method: ${header." + HTTP_METHOD + "}")
                .process(exchange -> {
                            log.info("this is the processor");
                    exchange.getIn().setHeader(HTTP_METHOD, POST);
                    exchange.getIn().setHeader("dummy", "true");
                        }

                )
                .log("Http method: ${header." + HTTP_METHOD + "}")
                .to("https://camelprocessor.free.beeceptor.com/my/api/path");
}}
