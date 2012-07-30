package org.cdi.advocacy;

import javax.enterprise.inject.Alternative;

@Alternative
public class StandardAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Standard transport retries");
	}
}
