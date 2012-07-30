sample17
===============

Use CASE(TransportFactory using the annotation configuration from class not field to configure a new instance of the transport):

1 TransportConfig an annotation used for configuration

@Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface TransportConfig {
        int retries() default 5;
}

2 AutomatedTellerMachineImpl using TransportConfig to configure retries based class level

@Named("atm")
@TransportConfig(retries=7)
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine 

3 TransportFactory using the annotation configuration from class not field to configure a new instance of the transport
.....
@Produces ATMTransport createTransport(InjectionPoint injectionPoint) {
                
                Bean<?> bean = injectionPoint.getBean();
                TransportConfig transportConfig = bean.getBeanClass().getAnnotation(TransportConfig.class);

                StandardAtmTransport transport = new StandardAtmTransport();
                
                transport.setRetries(transportConfig.retries());
                return transport;
        
4 Output is :

deposit called
communicating with bank via Standard transport retries=7

