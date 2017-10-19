package org.npu.courseapp.domain;

public class Student {
	private long id;
	private String firstName;
	private String lastName;
	private String acctName;
	
	public Student() {
	}
	
	public Student(String lastName, String firstName, String acctName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.acctName = acctName;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean matchesId(long tstId) {
		return (tstId == id);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public boolean matchesAcctName(String tstAcctName) {
		return (acctName.equals(tstAcctName));
	}

	public long getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getAcctName() {
		return acctName;
	}
	
	public String toString() {
		String studStr = "Student[" + firstName + " " + lastName + "  acctName: " + acctName + "]";
		return studStr;
	}
	
	public boolean equals(Object otherObj) {
		Student otherStud;
		
		/* Verify that the two keys match: id and account name */
		if (!(otherObj instanceof Student)) return false;
		otherStud = (Student) otherObj;
		return (id == otherStud.id && acctName.equals(otherStud.acctName));
	}
}
