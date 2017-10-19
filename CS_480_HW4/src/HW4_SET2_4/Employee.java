package HW4_SET2_4;

public class Employee {
	private String First_name;
	private String Last_name;
	private double monthly_salary;
	public Employee(String fr,String ls,double ms){
		First_name=fr;
		Last_name=ls;
		monthly_salary=ms;
	}
	public Employee(){
		First_name="";
		Last_name="";
		monthly_salary=0.0;
	}
	public void set_First_name(String fr){
		this.First_name=fr;
	}
	public void set_Last_name(String ls){
		this.Last_name=ls;
	}
	public void set_monthly_salary(double ms){
		this.monthly_salary=ms;
	}
	public String get_First_name(){
		return this.First_name;
	}
	public String get_Last_name(){
		return this.Last_name;
	}
	public double get_monthly_salary(){
		return this.monthly_salary;
	}
	public String toString(){
		return First_name+" "+Last_name+" earns "+monthly_salary*12+" annually.";
	}
}
