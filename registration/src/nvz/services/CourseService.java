package nvz.services;
import java.util.ArrayList;

import nvz.data.Course;

public class CourseService {
	private static ArrayList<Course> courseStudents;

	public static ArrayList<String> getCourseStudents(String courseName) {
		Course course;
		
		course = getCourse(courseName);
		if (course != null) {
			return course.getStudentList();
		}
		
        return null;
	}
	
	public static Course getCourse(String courseName) {
		int i;
		Course tstCourse;
		String tstName;
		
		if (courseStudents == null) {
			initCourseList();
		}
		
		for (i=0; i<courseStudents.size(); i++) {
			tstCourse = courseStudents.get(i);
			tstName = tstCourse.getName();
			if (tstName.equals(courseName)) {
				return tstCourse;
			}
		}
		
		return null;
	}
	
	private static void initCourseList() {
		Course course;
		courseStudents = new ArrayList<Course>();
		course = new Course("CS150");
		courseStudents.add(course);
		course = new Course("CS200");
		courseStudents.add(course);
	}
	
	public static void addStudentToCourse(String courseName, String studentName) {
		Course course;
		
		course = getCourse(courseName);
		course.addStudent(studentName);
	}
	
	public static ArrayList<Course> getCourseList() {
		if (courseStudents == null) {
			initCourseList();
		}
		
		return courseStudents;
	}

}
