package A6;

import java.util.List;

public class Contact {
	 String name;
	 String address;
	 List<Integer> numbers;
	 Contact previous;
	 Contact next;
	public Contact(String name, String address, List<Integer> numbers) {
		this.name = name;
		this.address = address;
		this.numbers = numbers;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", address=" + address + ", numbers=" + numbers+ "]";
	}
	 
}
