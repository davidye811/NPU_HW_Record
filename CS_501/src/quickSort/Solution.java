package quickSort;

import java.util.Arrays;
import java.util.Random;

public class Solution {
	static int[] arrayToSorted;
	public Solution(int[] arrayToSorted){
		this.arrayToSorted=arrayToSorted;
	}
	public void randomizedPartition(){
		//randomizedPartition(A,p,r);
		//exchange (A[r],A[l])
		
	}
	public void sort() {
		randomizedQuicksort(0, arrayToSorted.length - 1);
	}
	public String toString(){
		return Arrays.toString(arrayToSorted);
	}
	private void partition(int p,int r){
		int x=arrayToSorted[r];
		int i=p;
		int temp;
		for(int j=p;j<r-1;j++){
			if(arrayToSorted[j]<x){
				i=i+1;
				temp=arrayToSorted[i];
				arrayToSorted[i]=arrayToSorted[j];
				arrayToSorted[j]=temp;
			}
			temp=arrayToSorted[i+1];
			arrayToSorted[i+1]=arrayToSorted[r];
			arrayToSorted[r]=temp;
		}
		
	}
	private  void randomizedQuicksort(int begin,int end){
		int seed=arrayToSorted[end];
		int i = begin;
		int j = end;
		if(begin>=end)
			return ;
		while(i<j){
			while(i<j&&arrayToSorted[i]<=seed){
				i++;
			}
			if(i<j){
			int temp=arrayToSorted[i];
			arrayToSorted[i]=arrayToSorted[j];
			arrayToSorted[j]=temp;
			
			}
			while(i<j&&arrayToSorted[j]>=seed){
				j--;
			}
			if(i<j){
				int temp=arrayToSorted[i];
				arrayToSorted[i]=arrayToSorted[j];
				arrayToSorted[j]=temp;
				
			}
			
		}
		System.out.println(this);
		randomizedQuicksort(begin,j-1);
		randomizedQuicksort(i+1,end);
		
	}
	
	public static void main(String[] argv){
		int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		Solution a =new Solution(array);
//		a.partition(0, array.length-1);
		System.out.println(a);
		a.sort();
		System.out.println(a);
	}
}
