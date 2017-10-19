package org.npu.courseapp.domain;

/* An instance of one course -- represents the course offered for a particular semester */
public class CourseOffering {
	private long id;
	private Course course;
	private int maxEnroll;
	private int actualEnroll;
	
	public CourseOffering(Course course, int maxEnroll) {
		this.course = course;
		this.maxEnroll = maxEnroll;
		actualEnroll = 0;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public int getMaxEnroll() {
		return maxEnroll;
	}
	
	public void setMaxEnroll(int maxEnroll) {
		this.maxEnroll = maxEnroll;
	}
	
	public int getActualEnroll() {
		return actualEnroll;
	}
	
	public boolean enrollmentFull() {
		return actualEnroll >= maxEnroll;
	}
	
	public void setActualEnroll(int actualEnroll) {
		this.actualEnroll = actualEnroll;
	}
	
	/* To be written */
	public boolean equals(Object otherObj) {
		return false;
	}

}
