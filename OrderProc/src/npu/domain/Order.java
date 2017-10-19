package npu.domain;

public class Order {
	private String code;
	private double amount;
	private Customer cus;
	
	public Order(String newOrderCode) {
		code = newOrderCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}
	
}
