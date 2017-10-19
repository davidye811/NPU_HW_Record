package set3;

public class IncomeTax {
	int salary;
	final double basic_rate = 0.1;
	public IncomeTax(int salary){
		this.salary=salary;
	}
	public double calculateTax(int a){
		return a*basic_rate;
	}
	public String toString(){
		return "IncomeTax:"+calculateTax(salary);
		
	}
}
