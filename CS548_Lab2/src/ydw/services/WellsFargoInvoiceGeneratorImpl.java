package ydw.services;

import java.text.NumberFormat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ydw.domain.*;
import ydw.services.InvoiceGenerator;
@Component("WellsFargoinvoiceGenerator")
public class WellsFargoInvoiceGeneratorImpl implements InvoiceGenerator {
	@Value("${invoice.companyName_WellsFargo}")
	private String companyName;
	@Value("${invoice.cardnumber}")
	private String cardNumber;
	@Value("${invoice.payAmount}")
	private double payAmount;
	@Autowired
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public NumberFormat getDlrFormatter() {
		return dlrFormatter;
	}
	public void setDlrFormatter(NumberFormat dlrFormatter) {
		this.dlrFormatter = dlrFormatter;
	}
	public String getCompanyName() {
		return companyName;
	}



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

	
	
	public void produceInvoice(Student student) {
		System.out.println("Using the "+companyName+" credit card "+
		"processor to process credit card number "+student.getCardnumber()+" for"+student.getName()+". Payment of "+student.getTuitionAmount());
	}
	

}
