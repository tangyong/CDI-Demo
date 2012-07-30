sample15
===============

Use CASE(TransportFactory getting meta-data about the injection point):

 @Produces ATMTransport createTransport(InjectionPoint injectionPoint) {
                
       System.out.println("annotated " + injectionPoint.getAnnotated());
		System.out.println("bean " + injectionPoint.getBean());
		System.out.println("member " + injectionPoint.getMember());
		System.out.println("qualifiers " + injectionPoint.getQualifiers());
		System.out.println("type " + injectionPoint.getType());
		System.out.println("isDelegate " + injectionPoint.isDelegate());
		System.out.println("isTransient " + injectionPoint.isTransient());

		Bean<?> bean = injectionPoint.getBean();
		System.out.println("bean.beanClass " + bean.getBeanClass());
		System.out.println("bean.injectionPoints " + bean.getInjectionPoints());
		System.out.println("bean.name " + bean.getName());
		System.out.println("bean.qualifiers " + bean.getQualifiers());
		System.out.println("bean.scope " + bean.getScope());
		System.out.println("bean.stereotypes " + bean.getStereotypes());
		System.out.println("bean.types " + bean.getTypes());

		Annotated annotated = injectionPoint.getAnnotated();
		System.out.println("annotated.annotations "
				+ annotated.getAnnotations());
		System.out.println("annotated.annotations " + annotated.getBaseType());
		System.out.println("annotated.typeClosure "
				+ annotated.getTypeClosure());

        
                return new StandardAtmTransport();
                                
        }


The Output is:

annotated [field] @Inject private org.cdi.advocacy.AutomatedTellerMachineImpl.transport
bean Managed Bean [class org.cdi.advocacy.AutomatedTellerMachineImpl] with qualifiers [@Any @Default @Named]
member private org.cdi.advocacy.ATMTransport org.cdi.advocacy.AutomatedTellerMachineImpl.transport
qualifiers [@javax.enterprise.inject.Default()]
type interface org.cdi.advocacy.ATMTransport
isDelegate false
isTransient false

bean.beanClass class org.cdi.advocacy.AutomatedTellerMachineImpl
bean.injectionPoints [[field] @Inject private org.cdi.advocacy.AutomatedTellerMachineImpl.transport]
bean.name atm
bean.qualifiers [@javax.enterprise.inject.Any(), @javax.enterprise.inject.Default(), @javax.inject.Named(value=atm)]
bean.scope interface javax.enterprise.context.Dependent
bean.stereotypes []
bean.types [class java.lang.Object, class org.cdi.advocacy.AutomatedTellerMachineImpl, interface org.cdi.advocacy.AutomatedTellerMachine]

annotated.annotations [@javax.inject.Inject()]
annotated.annotations interface org.cdi.advocacy.ATMTransport
annotated.typeClosure [interface org.cdi.advocacy.ATMTransport]


deposit called
communicating with bank via Standard transport retries


