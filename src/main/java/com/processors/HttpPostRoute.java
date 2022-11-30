package com.processors;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import static org.apache.camel.Exchange.HTTP_METHOD;
import static org.springframework.http.HttpMethod.POST;

@Component
public class HttpPostRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
      from("timer:mytimer?period=5000")
              .setHeader(HTTP_METHOD).constant(HttpMethod.GET)
              .log("Httpmethod: ${header." + HTTP_METHOD + "}")
              .process(exchange ->{
                  log.info("we are in processor!");
                  exchange.getIn().setHeader(HTTP_METHOD, POST);
                  exchange.getIn().setHeader("dummy", "true");

              })
              .log("Httpmethod: ${header." + HTTP_METHOD + "}");
//              .to("log");
//              .to("https://camelprocessor.free.beeceptor.com/my/api/path");

    }
}
