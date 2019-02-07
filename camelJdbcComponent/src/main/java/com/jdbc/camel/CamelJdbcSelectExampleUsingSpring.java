package com.jdbc.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelJdbcSelectExampleUsingSpring {
    public static final void main(String[] args) throws Exception {
/*        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(
                appContext, false);*/
    	
    	CamelContext context = new DefaultCamelContext();
        try {            
        	context.start();
            Thread.sleep(20000);
        } finally {
        	context.stop();
        }
    }
}
