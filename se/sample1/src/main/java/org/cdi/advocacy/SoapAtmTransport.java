package org.cdi.advocacy;

public class SoapAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Soap transport retries");
	}
}
