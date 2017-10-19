package MyHashTable;

public class Solution {
	public static void main(String[] argv){
		MyHashTable a=new MyHashTable<String,Integer>(20);
		a.put("c",2);
		a.put("b",3);
		a.put("a",4);
		a.put("c",4);
		a.put("dsfsd", 232);
		System.out.println(a.containsKey("dsfsd"));
	}
}
