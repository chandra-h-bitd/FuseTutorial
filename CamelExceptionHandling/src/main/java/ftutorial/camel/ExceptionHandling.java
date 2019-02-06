package ftutorial.camel;

import java.io.IOException;

import javax.jms.ConnectionFactory;
import javax.xml.bind.UnmarshalException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ExceptionHandling {
	public static void main(String args[]) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		connectionFactory.setUserName("admin");
		connectionFactory.setPassword("admin");
		context.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new RouteBuilder() {
		public void configure() {


	        onException(IOException.class)
	            .handled(true)
	            .to("activemq:exceptioQueue")
	            .log(LoggingLevel.ERROR, "IOException An error occurred::::::::: ${exception.stacktrace} :::: Exception is handled")
	        ;
	        
	        onException(OutOfMemoryError.class)
            .handled(true).to("activemq:exceptioQueue").log(LoggingLevel.ERROR, "OutOfMemoryError An error occurred::::::::: ${exception.stacktrace} :::: Exception is handled");

	        onException(Throwable.class)
	            .handled(true)
	            .useOriginalMessage()
	            .log(LoggingLevel.ERROR, "Throwable An error occurred::::::::: ${exception.stacktrace} :::: Exception is handled");
			 
		from("file:/home/chardahe/Pictures/Training/CamelFiles/inbox").process(new TestOOM()).log("done");
			 
		}
		});
		context.start();
		Thread.sleep(100000);
		context.stop();
		}


}
