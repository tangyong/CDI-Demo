sample8
===============

Use CASE(Using @Qualifier to inject different types):

1 AutomatedTellerMachineImpl class uses setter method to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

By default, the aboved classes are all maked @Default

3 mark JsonRestAtmTransport, SuperFastAtmTransport as @Alternative, and StandardAtmTransport as @Default

4 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

5 define a @Soap Qualifier

6 add the defined @Soap Qualifier into SoapAtmTransport class

7 AutomatedTellerMachineImpl injecting SoapAtmTransport using new @Soap qualifier via setter method arg

    @Inject
    public void setTransport(@Soap ATMTransport transport) {
            this.transport = transport;
    }

8 when running AtmMain class,  the following output appears,

deposit called
communicating with bank via Soap transport retries

Note:
1) If also adding @Alternative into SoapAtmTransport class, then the following exception will happen
WELD-001408 Unsatisfied dependencies

2) If adding the following contents in beans.xml, then SoapAtmTransport class is still injected.

	<alternatives>
		<class>org.cdi.advocacy.JsonRestAtmTransport</class>
	</alternatives> 
