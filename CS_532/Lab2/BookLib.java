package Lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;



public class BookLib {
	Map<Integer,Book> lib;
	public BookLib(int SizeOfBook){
		lib=new HashMap<Integer,Book>();
		StringGenerator gener_8bits = new StringGenerator(8);
		StringGenerator gener_number = new StringGenerator(10000000);
		for(int i=0;i<SizeOfBook;i++){
			Book generBook=new Book(gener_8bits.generateStr(),gener_8bits.generateStr(),gener_number.generateRandNum(),
					(float)(gener_number.generateRandNum()*0.0001));
			lib.put(generBook.isbn, generBook);
		}
	}
	public Book SearchBookByISBN(int ISBN){
		return lib.get(ISBN);
	}
	public String toString(){
		StringBuffer a=new StringBuffer();
		for(Entry<Integer, Book> BookEntry:lib.entrySet()){
			a.append(BookEntry.getKey()+"\t\t"+BookEntry.getValue()+"\n");
		}
		return a.toString();
	}
	
}
