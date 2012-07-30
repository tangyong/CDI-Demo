sample13
===============

Use CASE(Using @Qualifiers with members to discriminate injection and stop the explosion of annotation creation):

1 create a Qualifier @Transport

@Qualifier @Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface Transport {
        TransportType type() default TransportType.STANDARD;
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

5 AutomatedTellerMachineImpl using @Inject @Transport(type=TransportType.STANDARD)
        @Inject @Transport(type=TransportType.STANDARD)
        private ATMTransport transport;
        
6 Output is as following:

deposit called
communicating with bank via Standard transport
