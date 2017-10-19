package set2;

public class Employee {
	int employeeNumber;
	public Employee(){
		this.employeeNumber=0;
	}

	public Employee(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + "]";
	}
}
