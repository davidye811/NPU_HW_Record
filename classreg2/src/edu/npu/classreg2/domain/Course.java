package edu.npu.classreg2.domain;

import java.util.*;

/*  One of our domain classes.   A domain class just stores
 *  data for our problem "domain".   It isn't providing "services"
 *  such as registering a student for a course, it just provides the data.
 *  See the "services" package to see what services can be performed.
 *  
 *  We could add another domain class called Student to store all the data 
 *  for a student.   Then the studentList data member below would be:
 *       private ArrayList<Student> studentList;
 *  Give this a try to get more programming experience.
 */
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
