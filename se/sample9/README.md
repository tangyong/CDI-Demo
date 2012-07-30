sample9
===============

Use CASE(Using @Qualfiers to inject multiple types into the same bean):

1 AutomatedTellerMachineImpl class uses setter method to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

By default, the aboved classes are all maked @Default

3 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

4 define @Soap, @Json and @SuperFast  Qualifieres

5 add the defined @Soap Qualifier into SoapAtmTransport class, and add @Json into JsonRestAtmTransport , and add @SuperFast into SuperFastAtmTransport

6 AutomatedTellerMachineImpl injecting SoapAtmTransport , JsonRestAtmTransport using new @Soap and @Json

        @Inject @Soap
        private ATMTransport soapTransport;
        
        @Inject @Json
        private ATMTransport jsonTransport;
        
        @Inject
        private ATMTransport standardTransport;

7 when running AtmMain class,  the following output appears,

deposit called
communicating with bank via JSON REST transport retries
