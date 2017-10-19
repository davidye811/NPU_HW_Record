package MyHashTable;

public class MyHashTable<E,V>{
	E e;
	V v;
	static int initialCapacity;
	static float loadFactor;
	static int SizeOfPoolUsed=0;
	MyEntry<E, V>[] Pool;
	public MyHashTable(){
		this.initialCapacity=11;
		this.loadFactor=(float) 0.75;
		Pool=new MyEntry[initialCapacity];
	}
	public MyHashTable(int initialCapacity){
		this.initialCapacity=initialCapacity;
		this.loadFactor=(float) 0.75;
		Pool=new MyEntry[initialCapacity];
	}
	public MyHashTable(int initialCapacity,float loadFactor){
		this.initialCapacity=initialCapacity;
		this.loadFactor=loadFactor;
		Pool=new MyEntry[initialCapacity];
	}
	public void put(E e,V v){
		if(Pool.length==0)
			return;
		int hash = e.hashCode();
		int index= (hash&0x7FFFFFFF)%Pool.length;
		if(Pool[index]==null){
			if(SizeOfPoolUsed==this.initialCapacity){
				this.Pool=this.CloneAndCopy(Pool);
				this.initialCapacity=(int)((double)initialCapacity/loadFactor)+1;
			}
		Pool[index]=new MyEntry<E,V>(e,v);
		SizeOfPoolUsed++;
		}
		else{
			MyEntry<E,V>  temp=Pool[index];
			while(true){
				if(temp.e.equals(e)){
					temp.v=v;
					break;
				}else if(temp.next==null){
					temp.next=new MyEntry<E,V>(e,v);
					SizeOfPoolUsed++;
					break;
				}else{
					temp=temp.next;
				}
				}
			}
	}
	public V get(E e){
		if(Pool.length==0)
			return null;
		int hash = e.hashCode();
		int index= (hash&0x7FFFFFFF)%Pool.length;
		MyEntry<E, V> temp=Pool[index];
		if(Pool[index]==null)
			return null;
		while(true){
			if(temp.e.equals(e)){
				return temp.v;
			}else if(temp.next==null){
				return null;
			}else{
				temp=temp.next;
			}
		}
		
	}
	MyEntry<E, V>[] CloneAndCopy(MyEntry<E, V>[] pool2){
		int NewSize=(int)((double)initialCapacity/loadFactor)+1;
		MyHashTable<E, V> newTable=new MyHashTable<E,V>(NewSize,loadFactor);
		for(MyEntry<E,V> temp:Pool){
			if(temp!=null){
			newTable.put(temp.e,temp.v);
			temp=temp.next;
			}
		}
		return newTable.Pool;
		
	}
	public boolean containsKey(E e){
		int hash= e.hashCode()&0x7FFFFFFF;
		int index=hash%Pool.length;
		MyEntry<E,V> temp=Pool[index];
		while(temp!=null){
			if(temp.e.equals(e)){
				return true;
			}
			temp=temp.next;
		}
		return false;
		
	}
	public boolean containsValue(V v){
		int hash= v.hashCode()&0x7FFFFFFF;
		int index=hash%Pool.length;
		MyEntry<E,V> temp=Pool[index];
		while(temp!=null){
			if(temp.v.equals(v)){
				return true;
			}
			temp=temp.next;
		}
		return false;
		
	}
	public String toString(){
		StringBuffer sb=new StringBuffer();
		for(MyEntry<E,V> temp:Pool){
			if(temp!=null){
			sb.append("{"+temp.e+","+temp.v+"}\n");
			temp=temp.next;
			}
		}
		return sb.toString();
	}
}
