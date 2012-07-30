sample1
===============

Use CASE(WELD-001409 Ambiguous dependencies):

1 AutomatedTellerMachineImpl class uses setter method to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

By default, the aboved classes are all maked @Default

3 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

4 when running AtmMain class, because the aboved classes are all maked @Default, the following exception will happen,

WELD-001409 Ambiguous dependencies for type [ATMTransport] with qualifiers [@Default] at injection point [[parameter 1] of [method] @Inject public org.cdi.advocacy.AutomatedTellerMachineImpl.setTransport(ATMTransport)]. Possible dependencies [[Managed Bean [class org.cdi.advocacy.SuperFastAtmTransport] with qualifiers [@Any @Default], Managed Bean [class org.cdi.advocacy.SoapAtmTransport] with qualifiers [@Any @Default], Managed Bean [class org.cdi.advocacy.StandardAtmTransport] with qualifiers [@Any @Default], Managed Bean [class org.cdi.advocacy.JsonRestAtmTransport] with qualifiers [@Any @Default]]]
