package org.npu.courseapp.dao;

import org.npu.courseapp.domain.Course;
import org.npu.courseapp.exceptions.UnknownTableEntryException;

public interface CourseDao {
	public Course findCourseByName(String courseName) throws UnknownTableEntryException;
	public void insertCourse(Course newCourse);
}
