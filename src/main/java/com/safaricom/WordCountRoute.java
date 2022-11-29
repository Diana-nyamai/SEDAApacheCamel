package com.safaricom;

import org.apache.camel.builder.ExpressionBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class WordCountRoute extends RouteBuilder {
    static final String receiveTextUri = "seda:receiveText?concurrentConsumers=5";
    static final String splitWordsUri = "seda:splitWords?concurrentConsumers=5";
    static final String toLowerCase = "seda:toLowerCase?concurrentConsumers=5";
    static final String countWordsUri = "seda:countWords?concurrentConsumers=5";
    static final String returnResponse = "mock:result";

    @Override
    public void configure() throws Exception {
        from(receiveTextUri)
                .to(splitWordsUri);

        from(splitWordsUri)
                .transform(ExpressionBuilder.bodyExpression(s -> s.toString().split(" ")))
                .to(toLowerCase);
        from(toLowerCase)
                .split(body(), new ArrayListAgreggationStrategy())
                .transform(ExpressionBuilder.bodyExpression(body -> body.toString().toLowerCase()))
                .end()
                .to(countWordsUri);
        from(countWordsUri)
                .transform(ExpressionBuilder.bodyExpression(List.class, body -> body.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))))
                .to(returnResponse);


    }
}
