package MyHashTable;

public class Solution {
	public static void main(String[] argv){
		MyHashTable a=new MyHashTable<Integer,Integer>(20);
		int[] list={1122, 9875, 4902, 7864, 2945, 4902, 8825, 5328, 1297, 3190};
		for(int m:list)
			a.put(m, m);
		System.out.println(a);
	}
}
