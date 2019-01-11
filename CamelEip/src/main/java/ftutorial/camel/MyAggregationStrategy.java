package ftutorial.camel;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    	
        if (oldExchange == null) {
            return newExchange;
        }
        String input2 = newExchange.getIn().getBody(String.class);
        String input1 = oldExchange.getIn().getBody(String.class);

        
        String output = input1+"\n"+input2;
        oldExchange.getIn().setBody(output);

        return oldExchange;
    }
}