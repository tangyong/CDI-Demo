package org.cdi.advocacy;

@Transport(type=TransportType.SOAP)
public class SoapAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Soap transport");
	}
}
