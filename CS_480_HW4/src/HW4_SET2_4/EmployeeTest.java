package HW4_SET2_4;

public class EmployeeTest {
	public static void main(String[] argv){
		Employee a1= new Employee();
		Employee a2= new Employee();
		a1.set_First_name("York");
		a1.set_Last_name("John");
		a1.set_monthly_salary(5500.0);
		a2=new Employee("David","James",2101.3);
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		a1.set_monthly_salary(a1.get_monthly_salary()*1.1);
		a2.set_monthly_salary(a2.get_monthly_salary()*1.1);
		System.out.println("after revise");
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println("test get method");
		System.out.println("First_name:"+a2.get_First_name());
		System.out.println("Last_name :"+a2.get_Last_name());
		System.out.println("salary is :"+a2.get_monthly_salary());
	}
}
