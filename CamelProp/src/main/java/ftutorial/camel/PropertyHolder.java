package ftutorial.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class PropertyHolder implements Processor {

	private static final Logger LOGGER = Logger.getLogger(PropertyHolder.class);
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void process(Exchange input) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Password ::::: "+getPassword());
		LOGGER.error("Password ::::: "+getPassword());
		
	}
	
	
	
}
