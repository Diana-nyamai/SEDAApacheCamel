package com.safaricom;

import org.springframework.stereotype.Component;

@Component
public class Endpoints {
    static final String receiveTextUri = "seda:receiveText?concurrentConsumers=5";
    static final String splitWordsUri = "seda:splitWords?concurrentConsumers=5";
    static final String toLowerCase = "seda:toLowerCase?concurrentConsumers=5";
    static final String countWordsUri = "seda:countWords?concurrentConsumers=5";
    static final String returnResponse = "mock:result";
}
