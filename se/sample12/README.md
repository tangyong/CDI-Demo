sample12
===============

Use CASE(Using multiple @Qualifiers at the same injection point to discriminate further):

1 AutomatedTellerMachineImpl class uses fields to inject bean which implements the ATMTransport interface
2 classes that implement the ATMTransport interface have four classes:

1)JsonRestAtmTransport
2)SoapAtmTransport
3)StandardAtmTransport
4)SuperFastAtmTransport

3 AutomatedTellerMachineImpl class is marked @Named("atm") in order to AtmMain class looks up it using getBeanByName method.

4 define @Soap, @Json and @SuperFast @StandardFrameRelaySwitchingFlubber Qualifieres

5 add @SuperFast and @StandardFrameRelaySwitchingFlubber into SuperFastAtmTransport class

6 add @Default and @StandardFrameRelaySwitchingFlubber into StandardAtmTransport class

7 on inject point, add @Inject @SuperFast @StandardFrameRelaySwitchingFlubber

8 when running AtmMain class,  the following output appears,

deposit called
communicating with bank via the Super Fast transport 
