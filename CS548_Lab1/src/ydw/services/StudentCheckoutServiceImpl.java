package ydw.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ydw.domain.Course;
import ydw.domain.Student;
@Service("StuCheckService")
public class StudentCheckoutServiceImpl implements StudentCheckoutService {
	@Value("${invoice.typeOfPaymentMethod}")
	private String paymentMethod;
	@Value("${invoice.typeOfTuitionCalculater}")
	private String checkOutMethod;
	@Autowired
	@Value("${invoice.payAmount}")
	private double payAmount;
	@Autowired
	@Qualifier("TuitionCalculatorNational")
	private TuitionCalculatorService tuitioncalculatorservice1;
	@Autowired
	@Qualifier("TuitionCalculatorOSU")
	private TuitionCalculatorService tuitioncalculatorservice2;
	public double getPayAmount() {
		return payAmount;
	}
	
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCheckOutMethod() {
		return checkOutMethod;
	}

	public void setCheckOutMethod(String checkOutMethod) {
		this.checkOutMethod = checkOutMethod;
	}

	

	public TuitionCalculatorService getTuitioncalculatorservice1() {
		return tuitioncalculatorservice1;
	}

	public void setTuitioncalculatorservice1(TuitionCalculatorService tuitioncalculatorservice1) {
		this.tuitioncalculatorservice1 = tuitioncalculatorservice1;
	}

	public InvoiceGenerator getInvoicegenerator1() {
		return invoicegenerator1;
	}

	public void setInvoicegenerator1(InvoiceGenerator invoicegenerator1) {
		this.invoicegenerator1 = invoicegenerator1;
	}



	@Autowired
	@Qualifier("PaypalinvoiceGenerator")
	private InvoiceGenerator invoicegenerator1;
	@Autowired
	@Qualifier("WellsFargoinvoiceGenerator")
	private InvoiceGenerator invoicegenerator2;
	
	@Override
	public void checkOut(Student student, List<Course> courses, String cardnumber) {
		InvoiceGenerator invoicegenerator = null;
		TuitionCalculatorService tuitioncalculatorservice = null;
		if(this.paymentMethod.equals("PaypalinvoiceGenerator")){
			 invoicegenerator=invoicegenerator1;
		}else{
			invoicegenerator=invoicegenerator2;
		}// TODO Auto-generated method stub
		if(this.checkOutMethod.equals("TuitionCalculatorNational")){
			 tuitioncalculatorservice=tuitioncalculatorservice1;
		}else{
			 tuitioncalculatorservice=tuitioncalculatorservice2;
		}
		double totalTuition=tuitioncalculatorservice.computeTutition(student, courses);
		student.setTuitionAmount(totalTuition);
		student.setCardnumber(cardnumber);
		invoicegenerator.produceInvoice(student);
		for(Course course:courses){
			course.setNumberOfStudent(course.getNumberOfStudent()+1);
			List<Student> students=course.getStudentsEnrolledIn();
			students.add(student);
			course.setStudentsEnrolledIn(students);
		}
	}

}
