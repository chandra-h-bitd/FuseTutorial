package threadpools;
import java.util.concurrent.ExecutorService;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ThreadPoolBuilder;

public class CustomThreadPoolInlineRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CamelContext context = getContext();
        ExecutorService executorService = new ThreadPoolBuilder(context).poolSize(5).maxQueueSize(100).build("CustomThreadPool");

        from("direct:in")
            .log("Received ${body}:${threadName}")
            .threads().executorService(executorService)
            .log("Processing ${body}:${threadName}")
            .transform(simple("${threadName}"))
            .to("mock:out");
    }
}