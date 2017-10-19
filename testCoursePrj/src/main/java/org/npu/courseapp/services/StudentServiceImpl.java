package org.npu.courseapp.services;

import org.apache.log4j.Logger;
import org.npu.courseapp.dao.StudentDAO;
import org.npu.courseapp.domain.Student;
import org.npu.courseapp.exceptions.DuplicateTableEntryException;
import org.npu.courseapp.exceptions.UnknownTableEntryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	@Qualifier("studentDaoMock")
	private StudentDAO studentDAO;
	private static Logger logger = Logger.getLogger(StudentServiceImpl.class);
	
	public void addNewStudent(Student stud) throws DuplicateTableEntryException {
		studentDAO.insertStudent(stud);
	}
	
	public void deleteStudent(Student stud) throws UnknownTableEntryException {
		studentDAO.deleteStudent(stud);
	}
	
	public Student findStudentByAcctName(String acctName) {
		return studentDAO.findStudentByAcctName(acctName);
	}
}

