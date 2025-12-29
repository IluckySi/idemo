package com.ilucky.idemo.test.jaeger;

import io.jaegertracing.Configuration;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

public class JaegerTest {
    public static void main(String[] args) {
        System.out.println("jaeger test");

        Configuration config = new Configuration("IDemo_APP");
        Configuration.SenderConfiguration senderConfig = new Configuration.SenderConfiguration();
        senderConfig.withAgentHost("10.100.7.47");
        senderConfig.withAgentPort(5775);
        config.withReporter(new Configuration.ReporterConfiguration().withSender(senderConfig).withFlushInterval(100).withLogSpans(false));
        config.withSampler(new Configuration.SamplerConfiguration().withType("const").withParam(1));

        
        
        
        
        
        
        io.opentracing.Tracer tracer = config.getTracer();
        System.out.println(tracer.toString());
        GlobalTracer.register(tracer);

        Tracer.SpanBuilder spanBuilder = GlobalTracer.get().buildSpan("hello");
        Span parent = spanBuilder.start();
        parent.log(100, "haha");

        Tracer.SpanBuilder spanBuilder2 = GlobalTracer.get().buildSpan("world").asChildOf(parent);
        Span child = spanBuilder2.start();
        child.log("haha2");
        child.finish();

        parent.finish();
    }
}
