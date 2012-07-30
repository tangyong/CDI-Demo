sample11
===============

Use CASE(Using @Produces that uses qualifiers to make a decision about creation):

1 AutomatedTellerMachineImpl class uses fields to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

3 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

4 define @Soap, @Json and @SuperFast  Qualifieres

5 add the defined @Soap Qualifier into SoapAtmTransport class, and add @Json into JsonRestAtmTransport , and add @SuperFast into SuperFastAtmTransport,
and add @Alternative into StandardAtmTransport class(Note: if not adding, because on the sample, @Produces method by defalut has @Default, so, once running
AtmMain class, will have a conflict with @Default injection)

6 create a Producer factory method that makes a decision about the creation and selection of the transport based on qualifiers as followings:

@Produces
	ATMTransport createTransport(@Soap ATMTransport soapTransport,
			@Json ATMTransport jsonTransport)

7 when running AtmMain class,  the following output appears,

ATMTransport created with producer makes decisions
return passed JSON transport
deposit called
communicating with bank via JSON REST transport retries
