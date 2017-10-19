package WFsearch;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	static int[] T={9,1,4,9,0,4,8,9,0,1};
	static int NumberOfPoint=T.length;
	static int cap;
	public static void main(String[] argv){
		boolean[] CheckIfFind=new boolean[NumberOfPoint];
		for(int i =0;i<T.length;i++){
			if(T[i]==i){
				cap=i;
				
			}else
				continue;
		}
		Wfs(T,cap);
	}
	
	static void WFs(int[] T,int cap){
		
	}
}
