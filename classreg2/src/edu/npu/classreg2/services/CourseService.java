package edu.npu.classreg2.services;
import java.util.ArrayList;

import edu.npu.classreg2.domain.Course;

/* This class performs various services on a Course.  For example,
 * enrolling a student in a course or retrieving a list of all the  
 * students in a course.  You could add code to this class to drop a student from
 * a course.   Services are the "business logic".   They take typically take domain
 * objects and perform business logic on them -- such as taking a Course object and a 
 * Student object and enrolling the Student in the course.
 * 
 * Normally the CourseService would retrieve/store data in a database.   But to keep
 * things simple for this project, we'll simulate a database by just using an ArrayList.
 *
 */
public class CourseService {
	private static ArrayList<Course> courseList;

	public static ArrayList<String> getCourseStudents(String courseName) {
		Course course;
		
		course = getCourse(courseName);
		if (course != null) {
			return course.getStudentList();
		}
		
        return null;
	}
	
	private static Course getCourse(String courseName) {
		int i;
		Course tstCourse;
		String tstName;
		
		if (courseList == null) {
			initCourseList();
		}
		
		for (i=0; i<courseList.size(); i++) {
			tstCourse = courseList.get(i);
			tstName = tstCourse.getName();
			if (tstName.equals(courseName)) {
				return tstCourse;
			}
		}
		
		return null;
	}
	
	private static void initCourseList() {
		Course course;
		courseList = new ArrayList<Course>();
		course = new Course("CS150");
		courseList.add(course);
		course = new Course("CS200");
		courseList.add(course);
	}
	
	public static void addStudentToCourse(String courseName, String studentName) {
		Course course;
		
		course = getCourse(courseName);
		course.addStudent(studentName);
	}
	
	public static ArrayList<Course> getCourseList() {
		if (courseList == null) {
			initCourseList();
		}
		
		return courseList;
	}

}
