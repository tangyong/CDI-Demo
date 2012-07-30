sample7
===============

Use CASE(Using @Alternative to select an Alternative on beans.xml):

1 AutomatedTellerMachineImpl class uses setter method to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

By default, the aboved classes are all maked @Default

3 mark JsonRestAtmTransport,  SoapAtmTransport, SuperFastAtmTransport as @Alternative, and StandardAtmTransport as @Default

4 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

5 On beans.xml, add the following contents:

	<alternatives>
		<class>org.cdi.advocacy.JsonRestAtmTransport</class>
	</alternatives>
	
Note:  if JsonRestAtmTransport,  SoapAtmTransport, SuperFastAtmTransport and StandardAtmTransport have more than 1 @Default marked, 
then, WELD-001409 Ambiguous dependencies will happen.

6 when running AtmMain class,  the following output appears,

deposit called
communicating with bank via JSON REST transport retries
