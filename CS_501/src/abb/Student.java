package abb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Student {
	
public static void main(String[] argv){
	Map hm = new ConcurrentHashMap(); 
	hm.put(null, "asdf");//1         
	hm.put("aaa", null);
}
}
