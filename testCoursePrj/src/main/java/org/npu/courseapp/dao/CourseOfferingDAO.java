package org.npu.courseapp.dao;

import org.npu.courseapp.domain.Course;
import org.npu.courseapp.domain.CourseOffering;
import org.npu.courseapp.exceptions.UnknownTableEntryException;

public interface CourseOfferingDAO {
	public CourseOffering findCourseOfferingByName(String courseName);
	public CourseOffering findCourseOfferingByCourse(Course course);
	public long insertCourseOffering(CourseOffering courseOffering);
	public void deleteCourseOffering(CourseOffering courseOffering);
	public int getCourseOfferingCount();
	public int getEnrollmentByCourseName(String courseName);
	public int getMaxEnrollmentById(long id);
	public int incrementCourseOfferingEnrollment(CourseOffering courseOffering) throws UnknownTableEntryException;
	public int decrementCourseOfferingEnrollment(CourseOffering courseOffering) throws UnknownTableEntryException;
}
