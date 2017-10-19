package HW4_SET2_3;

public class Invoice {
	private String number;
	private String description;
	private int quantity;
	private double price;
	public Invoice(){
		number="";
		description="";
		quantity=0;
		price=0.0;
	}
	public Invoice(String number,String description,int quantity,double price){
		this.number=number;
		this.description=description;
		this.quantity=quantity;
		this.price=price;
	}
	public void set_number(String number){
		this.number=number;
	}
	public void set_description(String description){
		this.description=description;
	}
	public void set_quantity(int quantity){
		this.quantity=quantity;
	}
	public void set_price(double price){
		this.price=price;
	}
	public String get_number(){
		return this.number;
	}
	public String get_description(){
		return this.description;
	}
	public int get_quantity(){
		return this.quantity;
	}
	public double get_price(){
		return this.price;
	}
	public double getAmount(){
		return quantity*price;
	}
	@Override
	public String toString() {
		return "Invoice [number=" + number + ", description=" + description + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}
