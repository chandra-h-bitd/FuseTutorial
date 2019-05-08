package ftutorial.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TestProp implements Processor {

	public void process(Exchange input) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Password :: "+new PropertyHolder().getPassword());

	}
}
