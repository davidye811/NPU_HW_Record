package FindMaxProfitEx;


import java.util.LinkedList;

public class FindMaxProfit {
	static LinkedList<Integer> buyday=new LinkedList<Integer>();
	static LinkedList<Integer> sellday=new LinkedList<Integer>();
	static int buyIndex;
	static int sellIndex;
	public static void main(String[] argv){
		
	int[] price = {100,113,110,85,105,102,86,63,81,101,
			 94,106,101,79,94,90,97};
	int[] sub=new int[price.length-1];
	for(int i=0;i<price.length-1;i++){
		sub[i]=price[i+1]-price[i];
	}
	System.out.println("The maximum profit is "+MaxProfit(price,0,16)[0]);
	System.out.println("Buy on day "+(1+MaxProfit(price,0,16)[1])+" and sell on day "+(1+MaxProfit(price,0,16)[2]));
}
	static int[] MaxProfit(int[] array,int first,int end){
		int mid=(first+end)/2;
		int crossMidHighest=Integer.MIN_VALUE;
		int crossMidLowest=Integer.MAX_VALUE;
		int minIndex = 0;
		int maxIndex = 0;
		int[] result=new int[3];
		if(end-first<=1){
			result[0]= (array[end]-array[first])>0?(array[end]-array[first]):0;
			result[1]=first; 
			result[2]= end;
			return result;
		}
		for(int i=first;i<mid;i++){
			if(crossMidLowest>array[i]){
				crossMidLowest=array[i];
				minIndex=i;
				}
		}
		if(end==16)
			mid=(first+end)/2;
		for(int i=mid;i<end;i++){
			if(crossMidHighest<array[i]){
			crossMidHighest=array[i];
			maxIndex=i;
			}
		}
		int midCrossedMax=crossMidHighest-crossMidLowest;
		int[] leftmax = MaxProfit(array,first,mid);
		int[] rightmax=MaxProfit(array,mid+1,end);
		int[] maxTemp;
		if(leftmax[0]>rightmax[0]){
			maxTemp= leftmax;
		}else{
			maxTemp= rightmax;
		}if(maxTemp[0]>midCrossedMax){
			return maxTemp;
		}else{
			result[0]=midCrossedMax;
			result[1]=minIndex; 
			result[2]= maxIndex;
			return result;
		}
		
		
	}
	static int maxone(int left,int right,int mid){
		return ((left>right?left:right)>mid)?(left>right?left:right):mid;
	}
}
