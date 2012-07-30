package org.cdi.advocacy;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

public class TransportFactory {

	private boolean useJSON = true;
	private boolean behindFireWall = true;

	@Produces
	ATMTransport createTransport(@Soap ATMTransport soapTransport,
			@Json ATMTransport jsonTransport) {
	
		System.out
				.println("ATMTransport created with producer makes decisions");

		if (behindFireWall) {
			if (useJSON) {
				System.out.println("return passed JSON transport");
				return jsonTransport;
			} else {
				System.out.println("return passed SOAP transport");
				return soapTransport;
			}
		} else {
			System.out.println("Create Standard transport");
			return new StandardAtmTransport();
		}
	}
}
