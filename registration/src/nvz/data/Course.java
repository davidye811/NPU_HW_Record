package nvz.data;

import java.util.*;

public class Course {
	private String name;
	private ArrayList<String> studentList;
	
	public Course(String name) {
		this.name = name;
		studentList = new ArrayList<String>();
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(ArrayList<String> studentList) {
		this.studentList = studentList;
	}
	
	public void addStudent(String studentName) {
		studentList.add(studentName);
	}
}
