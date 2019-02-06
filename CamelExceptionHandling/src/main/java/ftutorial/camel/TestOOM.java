package ftutorial.camel;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.OnExceptionDefinition;

public class TestOOM implements Processor{

	private static final int MEGABYTE = (1024*1024);


	@Override
	public void process(Exchange exchange) throws Exception {

        int size = Integer.MAX_VALUE;

        while (true) { byte[] bytes = new byte[size];
        System.out.println("Succeed!");
        break;
        
        }
		
	
	}

}
