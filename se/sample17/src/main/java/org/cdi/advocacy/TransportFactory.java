package org.cdi.advocacy;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;

public class TransportFactory {

	@Produces
	ATMTransport createTransport(InjectionPoint injectionPoint) {

		Bean<?> bean = injectionPoint.getBean();
        TransportConfig transportConfig = bean.getBeanClass().getAnnotation(TransportConfig.class);

        StandardAtmTransport transport = new StandardAtmTransport();
        
        transport.setRetries(transportConfig.retries());
        return transport;
	}
}
