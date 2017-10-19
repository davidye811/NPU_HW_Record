package Lab2;

public class Book {
	String author;
	String titile;
	int isbn;
	

	float price;
	
	public Book(String author, String titile, int isbn, float price) {
		super();
		this.author = author;
		this.titile = titile;
		this.isbn = isbn;
		this.price = price;
	}
	public boolean equals(Book a){
		return this.isbn!=a.isbn;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", titile=" + titile + ", isbn=" + isbn + ", price=" + price + "]";
	}
}
