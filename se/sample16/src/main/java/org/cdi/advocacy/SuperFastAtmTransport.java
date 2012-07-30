package org.cdi.advocacy;

@Transport(type=TransportType.STANDARD, priorityLevel=1)
public class SuperFastAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via the Super Fast transport " );
	}

	@Override
	public void setRetries(int retries) {
		// TODO Auto-generated method stub
		
	}
}