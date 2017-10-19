package nvz.client;
import nvz.domain.*;
import nvz.services.*;
import nvz.services.InvoiceGenerator;

import org.springframework.context.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InvoiceApp {
	public static void main(String args[]) {
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		container.registerShutdownHook();
		InvoiceGenerator invGenerator = (InvoiceGenerator) container.getBean("invoiceGenerator");
		Order order;
		
		order = new Order("GSX-56789");
		order.setAmount(20.0);
		invGenerator.produceInvoice(order);
	}
}	
