sample6
===============

Use CASE(@Produces):

1 AutomatedTellerMachineImpl class uses fields to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

By default, the aboved classes are all maked @Default

3 mark JsonRestAtmTransport,  SoapAtmTransport, SuperFastAtmTransport and StandardAtmTransport as @Alternative

4 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

5 using TransportFactory to create ATMTransport by means of @Produces, note that StandardAtmTransport also needs to be marked as @Alternative,
otherwise, WELD-001409 Ambiguous dependencies will happen.

6 when running AtmMain class,  the following output appears,

ATMTransport created with producer
deposit called
communicating with bank via Standard transport retries
