package org.cdi.advocacy;

public class JsonRestAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via JSON REST transport retries=");
	}
}
