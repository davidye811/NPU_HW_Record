package Insertionsort;

public class Solution {
	public static void main(String[] argv){
		int[] a={120, 250, 30, 425, 5, 70, 700, 385};
		a=insertion(a);
		System.out.print("Insertion Sort result is:");
		for(int i = 0;i<a.length;i++){
			System.out.print(" "+a[i]);
			if(i<a.length-1)
				System.out.print(",");
		}
	}
	public static int[] insertion(int[] array){
		
		for(int j=1;j<array.length;j++){
			for(int i=j;i>0;i--){
			if(array[i]<array[i-1]){
				int temp=array[i];
				array[i]=array[i-1];
				array[i-1]=temp;
				}
			else 
				break;
			}
		}
		return array;
	}
	
}
