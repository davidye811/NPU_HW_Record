package LargestSmallestSearch;

public class LargestSmallestSearch {
	public static void main(String[] argcv){
		int[] array={95, 70, 82, 175, 48, 63, 15, 53};
		System.out.println(LargestSmallestSearch(array));
	}
	static String LargestSmallestSearch(int[] array){
		StringBuffer sb=new StringBuffer();
		int smallNumber= Integer.MAX_VALUE;
		int bigNumber =Integer.MIN_VALUE;
		for(int i = 0;i<array.length;i++){
			if(array[i]>bigNumber)
				bigNumber=array[i];
			if(array[i]<smallNumber)
				smallNumber=array[i];
		}
		sb.append("The smallest number is "+smallNumber+"\nThe largest number is "+bigNumber);
		return sb.toString();
	}
}
