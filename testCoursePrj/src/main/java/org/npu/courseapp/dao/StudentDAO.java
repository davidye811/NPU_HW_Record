package org.npu.courseapp.dao;

import java.util.List;

import org.npu.courseapp.domain.Student;
import org.npu.courseapp.exceptions.DuplicateTableEntryException;
import org.npu.courseapp.exceptions.UnknownTableEntryException;


public interface StudentDAO {
	public List<Student> findAllStudents();
	public Student findStudentById(long id);
	public Student findStudentByAcctName(String acctName);
	public long insertStudent(Student stud) throws DuplicateTableEntryException;
	public void deleteStudent(Student stud) throws UnknownTableEntryException;
	public int getStudentCount();

}
