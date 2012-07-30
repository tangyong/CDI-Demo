sample16
===============

Use CASE(Using @Produces and InjectionPoint to create configuration annotations):

1 TransportConfig an annotation used for configuration

@Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface TransportConfig {
        int retries() default 5;
}

2 AutomatedTellerMachineImpl using TransportConfig to configure retries
        @Inject @TransportConfig(retries=2)
        private ATMTransport transport;

3 Output is as following:
.....
annotated.annotations [@org.cdi.advocacy.TransportConfig(retries=2), @javax.inject.Inject()]
.....

deposit called
communicating with bank via Standard transport

Note: This means the annotation data is there. We just need to grab it and use it. Stop and ponder on this a bit. This is pretty cool. 
The producer allows me to customize how annotations are consumed. This is powerful stuff and one of the many extention points avaialable to CDI. 

4 ATMTransport adding a retries property

public interface ATMTransport {
	public void communicateWithBank(byte[] datapacket);
	public void setRetries(int retries);
}

5 StandardAtmTransport adding a retries property

6 TransportFactory using the annotation configuration to configure a new instance of the transport

@Produces ATMTransport createTransport(InjectionPoint injectionPoint) {
                
                Annotated annotated = injectionPoint.getAnnotated();
                
                TransportConfig transportConfig = annotated.getAnnotation(TransportConfig.class);               
                
                StandardAtmTransport transport = new StandardAtmTransport();
                
                transport.setRetries(transportConfig.retries());
                return transport;
        }
        
7 Output is :

deposit called
communicating with bank via Standard transport retries=2

