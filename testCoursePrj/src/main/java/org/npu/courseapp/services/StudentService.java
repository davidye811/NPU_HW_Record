package org.npu.courseapp.services;

import org.npu.courseapp.domain.Student;
import org.npu.courseapp.exceptions.DuplicateTableEntryException;
import org.npu.courseapp.exceptions.UnknownTableEntryException;

public interface StudentService {
	public void addNewStudent(Student stud) throws DuplicateTableEntryException;
	public void deleteStudent(Student stud) throws UnknownTableEntryException;
	public Student findStudentByAcctName(String acctName);
}
