package com.decisionmaking;


import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DecisionMaking extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        Predicate isfirst = header("dummy").isEqualTo(1);
        Predicate issecond = header("dummy").isEqualTo(2);
        from("timer:decision?period=10000")
                .id("decsion making route")
                .setHeader("dummy").constant(1)
                .choice()
                    .when(isfirst)
                    .log("first condition")
                .to("direct:next")
                    .when(issecond)
                    .log("second condition")
                    .otherwise()
                    .log("otherwise")
                .endChoice();
        from("direct:next")
                .log("this is a new route");

    }
}
//choice uses this logic
//        if(headervalue == 1){
//            firstcondition
//        }
//        else if(headervalue == 2){
//            secondcondition
//        }
//        else{
//
//        }