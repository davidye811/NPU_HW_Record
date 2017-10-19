package doubleHashingHashTable;

public class DoubleHashedTable<T> {
	private T[] table;
	private int tableCapacity;
	private int size;
	public DoubleHashedTable(int tableSize){
		table = (T[]) new Object[tableSize];
		this.tableCapacity = tableSize;
		size = 0;
	}
	public void add(T item){
		
	}
}
