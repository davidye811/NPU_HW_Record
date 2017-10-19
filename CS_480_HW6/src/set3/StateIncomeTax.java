package set3;

public class StateIncomeTax extends IncomeTax{
	int salary;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public StateIncomeTax(int salary) {
		super(salary);
		this.salary=super.salary;
	}
	public double calculateTax(int a ){
		return a*0.01+super.calculateTax(a);
	}
	double totalTax(){
		return this.calculateTax(salary)+super.calculateTax(salary);
	}
	public String toString(){
		return "StateIncomeTax:"+totalTax();
		
	}
	
}
