package org.npu.courseapp.services;

import org.npu.courseapp.domain.Course;
import org.npu.courseapp.domain.CourseOffering;

public interface CourseService {
	public void addNewCourse(Course course);
	public void addNewCourseOffering(CourseOffering course);
	public CourseOffering getCourseOfferingByName(String name);
	public int getEnrollmentForCourseOffering(String courseName);
}
