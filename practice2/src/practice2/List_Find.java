package practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class List_Find {				//i think that it is just need  .sort
	public static void main(String[] argv){
		List l1= new ArrayList();
		for(int i=0;i<100;i++){
			l1.add(Math.random());
		}
		l1.sort(null);
		for(int i=0;i<100;i++)
			System.out.println(l1.get(i));
		
	System.out.print("the 2nd min:");
	System.out.println(l1.get(1));
	System.out.print("the 2nd max:");
	System.out.print(l1.get(98));
	}

}
