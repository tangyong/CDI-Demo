package org.cdi.advocacy;

import java.math.BigDecimal;

import org.cdiadvocate.beancontainer.BeanContainer;
import org.cdiadvocate.beancontainer.BeanContainerManager;

public class AtmMain {

	static BeanContainer beanContainer =  BeanContainerManager.getInstance();

	public static void main(String[] args) throws Exception {
		beanContainer.start();
		AutomatedTellerMachine atm = (AutomatedTellerMachine) beanContainer
				.getBeanByName("automatedTellerMachineImpl");

		atm.deposit(new BigDecimal("1.00"));
	}
}
