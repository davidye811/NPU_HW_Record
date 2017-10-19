package com.nvz.courseapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.npu.courseapp.domain.Student;
import org.npu.courseapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:coursedao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {
	
	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;

	@Test
	public void  testInsertStudent() throws Exception {
		String acctName = "nwalters";
		Student stud = new Student("Walters", "Nancy", acctName);
		Student studFromDb;
		
		studFromDb = studentService.findStudentByAcctName(acctName);
		assertNull(studFromDb);
		
		studentService.addNewStudent(stud);
		studFromDb = studentService.findStudentByAcctName(acctName);
		assertEquals(stud, studFromDb);
	}
	
}
