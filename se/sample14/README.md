sample14
===============

Use CASE(Transport qualifier annotation with more than one member):

1 create a Qualifier @Transport

@Qualifier @Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface Transport {
        TransportType type() default TransportType.STANDARD;
        int priorityLevel() default -1;
}

2 Mark SoapAtmTransport with @Transport
@Transport(type=TransportType.SOAP)
public class SoapAtmTransport implements ATMTransport {

3 Mark StandardAtmTransport with @Transport
@Transport(type=TransportType.STANDARD)
public class StandardAtmTransport implements ATMTransport

4 Mark JsonRestAtmTransport with @Transport
@Transport(type=TransportType.JSON)
public class JsonRestAtmTransport implements ATMTransport

5 SuperFastAtmTransport using two qualifier members to qualify
@Transport(type=TransportType.STANDARD, priorityLevel=1)
public class SuperFastAtmTransport implements ATMTransport

6 AutomatedTellerMachineImpl using @Inject @Transport(type=TransportType.STANDARD, priorityLevel=1)
       	@Inject 
	    @Transport(type=TransportType.STANDARD, priorityLevel=1) 
	    private ATMTransport transport;
        
7 Output is as following:

deposit called
communicating with bank via the Super Fast transport
