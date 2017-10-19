package npu.client;
import npu.domain.*;
import npu.services.OrderProcessor;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderApplication {
	public static void main(String args[]) {
		ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		OrderProcessor orderProc = (OrderProcessor) container.getBean("orderProcessor");
		Order order;
		
		order = new Order("GSX-56789");
		orderProc.newOrder(order);
	}
}
