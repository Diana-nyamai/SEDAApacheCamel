package com.safaricom;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ApacheCamelSedaIntegrationTest extends CamelTestSupport {
    @Test
    public void givenTestWithCapitalAndSmallCaseAndWithoutDuplicateWords_whenSendingTextToInputUri_thenWordCountReturnedAsMap() throws InterruptedException{
        Map<String, Long> expected = new HashMap<>();
        expected.put("my", 1L);
        expected.put("name", 1L);
        expected.put("is", 1L);
        expected.put("ndinda", 1L);

        getMockEndpoint(WordCountRoute.returnResponse).expectedBodiesReceived(expected);
        template.sendBody(WordCountRoute.receiveTextUri, "my name is ndinda");
        assertMockEndpointsSatisfied();
    }
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception{
        RouteBuilder wordcountroute = new WordCountRoute();
        return wordcountroute;
    }
}
