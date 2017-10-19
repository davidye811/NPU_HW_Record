package set2;

public class Acount {//a.
	int Account;
	String Name;
	double money;
	Employee emp;
	Document doc;
	public Acount(){
		this.Account=0;
		this.Name="";
		this.money=0.0;
		this.emp=new Employee();
		this.doc=new Document();
	}
	public Acount(String Name){
		this();
		this.Name=Name;
	}
	public Acount(String Name,int money){
		this();
		this.Name=Name;
		this.money=money;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public void SavingsAccount(int AccountNunber){
		this.Account=AccountNunber;
	}
	public void SavingsAccount(int AccountNunber,boolean isEmployee){
		this.Account=AccountNunber;
		if(isEmployee=true)
		this.emp.setEmployeeNumber(AccountNunber);
	}
	@Override
	public String toString() {
		return "Acount [Account=" + Account + ", Name=" + Name + ", money=" + money + ", emp=" + emp + ", doc=" + doc
				+ "]";
	}
	
}
