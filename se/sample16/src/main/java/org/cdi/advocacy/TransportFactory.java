package org.cdi.advocacy;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

public class TransportFactory {

	@Produces
	ATMTransport createTransport(InjectionPoint injectionPoint) {

		Annotated annotated = injectionPoint.getAnnotated();
		TransportConfig transportConfig = annotated.getAnnotation(TransportConfig.class);
		StandardAtmTransport transport = new StandardAtmTransport();
		transport.setRetries(transportConfig.retries());

		return transport;
	}
}
