package ftutorial.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

/**
 * A bean which we use in the route
 */
public class FileProcessor implements Processor {

	 private String say = "You are inside Bean :: ";
	public void process(Exchange input) throws Exception {
		// TODO Auto-generated method stub
		
		say+= input.getIn().getBody(String.class);
		input.getIn().setBody(say);
	}
}
