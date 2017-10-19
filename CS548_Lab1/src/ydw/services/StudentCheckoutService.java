package ydw.services;

import java.util.List;

import ydw.domain.Course;
import ydw.domain.Student;

public interface StudentCheckoutService {
	public void checkOut(Student student, List<Course> courses,String cardNumber);
}
