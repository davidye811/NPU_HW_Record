package ydw.services;
import java.util.List;

import org.springframework.stereotype.Component;

import ydw.domain.Course;
import ydw.domain.Student;
import ydw.services.TuitionCalculatorService;

public class TuitionCalculatorOSUImpl implements TuitionCalculatorService {
		int a;
	public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
	@Override
	public double computeTutition(Student student, List<Course> courses) {
		// TODO Auto-generated method stub
		double totalPrices;
		int totalUnits = 0;
		for(Course course:courses){
			totalUnits+=course.getNumberOfUnit();
		}
		if(student.isGradute()){
			totalPrices=totalUnits*150;
		}else{
			totalPrices=totalUnits*100;
		}
		if(student.isInternational()){
			return totalPrices*1.1;
		}else{
			return totalPrices;
		}
	}
	

}
