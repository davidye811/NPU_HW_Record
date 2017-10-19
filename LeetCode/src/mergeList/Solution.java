package mergeList;

public class Solution{
	public static void main(String[] argv){
		int a[]={95, 70, 88, 125, 49, 67, 18, 53};
		int c[]=merge(a);
		System.out.print("Merge Sort result is ");
		for(int i = 0; i<c.length;i++){
			System.out.print(c[i]+" ");
		}
			
	}

	 static int[] merge(int[] array){
		 if(array.length<=1)
			 return array;
		 int[] lfarr=new int[array.length/2];
		 int[] riarr=new int[array.length-array.length/2];
		 for(int i=0;i<lfarr.length;i++){
			 lfarr[i]=array[i];
		 }
		 for(int i=0;i<riarr.length;i++){
			 riarr[i]=array[i+lfarr.length];
		 }

		 return merge2arr(merge(lfarr),merge(riarr));
		 
	 }
	static int[] merge2arr(int[] left,int[] right){
		if(left.length==0)
				return right;
		if(right.length==0)
			return left;
		int[] c=new int[left.length+right.length];
		int itrl=0,itrr=0,itrc=0;
		while(itrl<left.length & itrr<right.length){
			if(left[itrl]<=right[itrr]){
				c[itrc++]=left[itrl++];
			}else{
				c[itrc++]=right[itrr++];
			}
		}
		while(itrl<left.length){
			c[itrc++]=left[itrl++];
		}
		while(itrr<right.length){
			c[itrc++]=right[itrr++];
		}
		return c;
	}
	
}
