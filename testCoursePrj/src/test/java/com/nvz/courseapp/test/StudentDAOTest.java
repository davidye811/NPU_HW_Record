package com.nvz.courseapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.npu.courseapp.dao.StudentDAO;
import org.npu.courseapp.domain.Student;
import org.npu.courseapp.exceptions.DuplicateTableEntryException;
import org.npu.courseapp.exceptions.UnknownTableEntryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:coursedao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDAOTest {
	@Autowired
	@Qualifier("studentDaoMock")
	private StudentDAO studentDAO;
	private Student setupStudent;   /*  Initialized in the setup() method  */
	private long setupStudentId;    /*  Initialized in the setup() method  */

	@Before
	public void setup() {
		/*  We'll use this student in various tests. The student should already be in the database */
		setupStudent = new Student("Robbins", "John", "jrobbins");
		setupStudentId = 2;   /* In the DB, the student should have this id */
		setupStudent.setId(setupStudentId);
	}
	
	@Test
	public void testFindAcctByName() throws Exception {
		String acctName = setupStudent.getAcctName();
		Student studFromDb;
		
		studFromDb = studentDAO.findStudentByAcctName(acctName);
		assertNotNull(studFromDb);
		assertEquals(setupStudent,studFromDb);
	}
	
	@Test
	public void testFindAllStudents() {
		int studentCnt;
		List<Student> studList = studentDAO.findAllStudents();
		
		assertNotNull(studList);
		studentCnt = studentDAO.getStudentCount();
		assertEquals(studList.size(), studentCnt);
	}
	
	@Test
	public void testGetStudentCount() {
		List<Student> studList = studentDAO.findAllStudents();
		int count = studentDAO.getStudentCount();
		assertEquals(count, studList.size());
	}
	
	@Test
	public void testInsertDeleteStudent() throws Exception {
		Student stud = new Student("Williams", "Sherry", "swilliams");
		Student studFromDb;
		long id;
		
		/* first do the insert */
		int count = studentDAO.getStudentCount();
		id = studentDAO.insertStudent(stud);
		
		/* validate insert */
		int newCount = studentDAO.getStudentCount();
		assertEquals(count+1, newCount);
		studFromDb = studentDAO.findStudentById(id);
		assertEquals(stud.equals(studFromDb), true);
		
		/* do the delete */
		studentDAO.deleteStudent(studFromDb);
		
		/* validate the delete */
		newCount = studentDAO.getStudentCount();
		assertEquals(count, newCount);
	}
	
	
	@Test(expected=DuplicateTableEntryException.class)
	public void testDuplicateStudentInsert() throws Exception {
		studentDAO.insertStudent(setupStudent);
	}
	
	@Test(expected=UnknownTableEntryException.class)
	public void testUnknownStudentDelete() throws Exception {
		Student unknownStudent = new Student("Gizelle", "Nancy", "ngizzele");
		unknownStudent.setId(5);
		studentDAO.deleteStudent(unknownStudent);
	}
	
}
