package HW3Ex;

import java.util.ArrayList;
import java.util.HashSet;

public class Resource {
	private ArrayList<String> inputPool;
	private int count=0;
	Resource(ArrayList<String> inputPool){
		this.inputPool=inputPool;
	}
	public ArrayList<String> getInputPool() {
		return inputPool;
	}
	public void setInputPool(ArrayList<String> inputPool) {
		this.inputPool = inputPool;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
