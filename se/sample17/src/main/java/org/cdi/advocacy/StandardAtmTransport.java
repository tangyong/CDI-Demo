package org.cdi.advocacy;

@Transport(type=TransportType.STANDARD)
public class StandardAtmTransport implements ATMTransport {

	private int retries;

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Standard transport retries=" + retries);
	}

	@Override
	public void setRetries(int retries) {
		 this.retries = retries;		
	}
}
