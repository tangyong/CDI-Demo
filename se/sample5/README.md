sample5
===============

Use CASE(@Inject via fields):

1 AutomatedTellerMachineImpl class uses fields to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

By default, the aboved classes are all maked @Default

3 mark JsonRestAtmTransport,  SoapAtmTransport, SuperFastAtmTransport as @Alternative, and StandardAtmTransport as @Default

4 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

5 when running AtmMain class,  the following output appears,

deposit called
communicating with bank via Standard transport retries
