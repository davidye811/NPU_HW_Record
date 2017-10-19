package org.npu.courseapp.dao.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.npu.courseapp.dao.StudentDAO;
import org.npu.courseapp.domain.Student;
import org.npu.courseapp.exceptions.DuplicateTableEntryException;
import org.npu.courseapp.exceptions.UnknownTableEntryException;
import org.springframework.stereotype.Repository;

@Repository("studentDaoMock")
public class StudentDaoMockImpl implements StudentDAO {
	private static long idGenerator = 0;
	private ArrayList<Student> studList;

	@PostConstruct
	public void init() {
		Student stud;
		
		studList = new ArrayList<Student>();
		
		stud = new Student("Williams", "Bob", "wbob");
		idGenerator++;
		stud.setId(idGenerator);
		studList.add(stud);
		
		stud = new Student("Robbins", "John", "jrobbins");
		idGenerator++;
		stud.setId(idGenerator);
		studList.add(stud);
		
		stud = new Student("Ginzal", "Mary", "m_gin");
		idGenerator++;
		stud.setId(idGenerator);
		studList.add(stud);
	}
	
	public List<Student> findAllStudents() {
		return studList;
	}

	public Student findStudentById(long id) {
		for (Student tstStud: studList) {
			if (tstStud.matchesId(id)) {
				return tstStud;
			}
		}
		
		return null;
	}

	public Student findStudentByAcctName(String acctName) {
		for (Student tstStud: studList) {
			if (tstStud.matchesAcctName(acctName)) {
				return tstStud;
			}
		}
		
		return null;
	}

	public long insertStudent(Student stud) throws DuplicateTableEntryException {
		Student studFromDb;
		String acctName;
		
		if (!stud.matchesId(0)) {
			throw new DuplicateTableEntryException(stud + " already has an id?");
		}
		
		acctName = stud.getAcctName();
		studFromDb = findStudentByAcctName(acctName);
		if (studFromDb != null) {
			throw new DuplicateTableEntryException("Student with account name: " + acctName + " already exists");
		}
		
		idGenerator++;
		stud.setId(idGenerator);
		studList.add(stud);
		return idGenerator;
	}

	public void deleteStudent(Student stud) throws UnknownTableEntryException {
		int matchingStudIdx;
		
		matchingStudIdx = studList.indexOf(stud);
		if (matchingStudIdx == -1) {
			throw new UnknownTableEntryException(stud + " not found in the database");
		}
		
		studList.remove(matchingStudIdx);
	}

	public int getStudentCount() {
		return studList.size();
	}

}
