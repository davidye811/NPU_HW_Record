package ydw.client;
import ydw.domain.*;
import ydw.services.*;
import ydw.services.InvoiceGenerator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InvoiceApp {
	public static void main(String args[]) {
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		container.registerShutdownHook();
		StudentCheckoutService studentcheckoutservice = (StudentCheckoutService) container.getBean("StuCheckService");
		Student student;
		
		student = new Student(194213);
		student.setName("John Smith");
		Course c001=new Course("Fundemental Chemistry","Chemistry", false, 3,0,new ArrayList<Student>());
		Course c002=new Course("Advanced Math","Math", true, 6,0,new ArrayList<Student>());
		List<Course> courses=new ArrayList<Course>();
		courses.add(c002);courses.add(c001);
		studentcheckoutservice.checkOut(student, courses, "12123214125211321");
	}
}	
