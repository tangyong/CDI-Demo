sample18
===============

Use CASE(Using @Nonbinding to combine a configuration annotation and a qaulifier annotation into one annotation):

1 Transport qualifier annotation using @Nonbinding to add configuration retries param

@Qualifier @Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface Transport {
        TransportType type() default TransportType.STANDARD;
        int priorityLevel() default -1;
        String name() default "standard";
        
        @Nonbinding int retries() default 5;
}

2 Transport qualifier annotation using @Nonbinding to add configuration retries param

@Transport(type=TransportType.STANDARD, priorityLevel=1, name="super")
public class SuperFastAtmTransport implements ATMTransport 

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

However, I got the following result:
deposit called
communicating with bank via the Super Fast transport retries=0

That is to said: @Nonbinding has not any effect.

