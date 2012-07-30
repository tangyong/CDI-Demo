package org.cdi.advocacy;

public class StandardAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Standard transport retries");
	}
}
