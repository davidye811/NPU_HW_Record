package nvz.services;

import java.text.NumberFormat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import nvz.domain.Order;
import nvz.services.InvoiceGenerator;
@Service(value="invoiceGenerator")
public class InvoiceGeneratorImpl implements InvoiceGenerator {
	@Value("${invoice.companyName}")
	private String companyName;
	private int companyId;
	@Value("${invoice.salesTax}")
	private double salesTax;
	@Autowired
	@Qualifier("shippingCalculator")
	private ShippingChargeCalculator shippingCalculator;
	private NumberFormat dlrFormatter = NumberFormat.getCurrencyInstance();

	// Uncomment this to try constructor injection instead of setter injection
	/*
	public InvoiceGeneratorImpl(String companyName, int companyId,
			double salesTax, ShippingChargeCalculator shippingCalculator)
	{
		this.companyName = companyName;
		this.companyId = companyId;
		this.salesTax = salesTax;
		this.shippingCalculator = shippingCalculator;
	}
	*/
	@PostConstruct
	public void initIvnGen(){
		System.out.println("Initializing the Invoice Generator");
	}
	@PreDestroy
	public void shutdownIvnGen(){
		System.out.println("shutting down the Invoice Generator");
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}
	
	public double getSalesTax() {
		return salesTax;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setShippingCalculator(ShippingChargeCalculator shippingCalculator) {
		this.shippingCalculator = shippingCalculator;
	}

	public void produceInvoice(Order order) {
		double orderAmt = order.getAmount()	;
		String invNum = companyId + "-" + order.getId();
		double salesTaxAmt  = orderAmt * salesTax;
		double shipChargeAmt = shippingCalculator.shippingCharge(order);
		double totalAmt = shipChargeAmt + orderAmt + salesTaxAmt;
		
		System.out.println("Invoice by: " + companyName);
		System.out.println("Invoice Number: " + invNum);
		System.out.println("Amount: " + dlrFormatter.format(orderAmt));
		System.out.println("Sales Tax: " + dlrFormatter.format(salesTaxAmt));
		System.out.println("Shipping: " + dlrFormatter.format(shipChargeAmt));
		System.out.println("Total: " + dlrFormatter.format(totalAmt));
		return;
	}

}
