package set3;

public class FederalIncomeTax extends IncomeTax{
	
	int salary;
	
	public FederalIncomeTax(int salary) {
		super(salary);
		this.salary=super.salary;
	}
	public double calculateTax(int a){
		return a*0.02+super.calculateTax(a);
	}
	public double totalTax(){
		return this.calculateTax(salary)+super.calculateTax(salary);
	}
	public String toString(){
		return "FederalIncomeTax:"+this.totalTax();
		
	}
}
