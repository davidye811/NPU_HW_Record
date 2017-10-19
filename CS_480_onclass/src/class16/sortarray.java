package class16;

public class sortarray {
	

	public int[] algor1(int[] a, int[] b) {
		int i=0;
		int j=0;
		int[]result = new int[a.length+b.length];
		while(i<a.length&&j<b.length){
			if(a[i]>b[j]){
				result[i+j]=b[j];
				j++;
			}else{
				result[i+j]=a[i];
				i++;
			}
			
		}
		while(j<b.length){
			result[i+j]=b[j];
			j++;
		}
		while(i<a.length){
			result[i+j]=a[i];
			i++;
		}
		return result;
	
	}
	public int[] algor2(int[] a,int[]b){
		int i=a.length-b.length-1;
		int j=b.length-1;
		int al=a.length-1;
		while(i>-1&&j>-1){
			if(a[i]>b[j]){
			a[al]=a[i];
			i--;
			al--;
			}
			if(a[i]<b[j]){
				a[al]=b[j];
				j--;
				al--;
				}
			}
		while(i>-1){
			a[al]=a[i];
			i--;
			al--;
		}
		while(j>-1){
			a[al]=b[j];
			j--;
			al--;
		}
		return a;
		}
}
