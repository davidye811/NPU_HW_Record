package RandomizeInPlace;

import java.util.Arrays;

public class RandomizeInPlace {
	public static void main(String[] argv){
		int[] source=new int[100];
		for(int i=0;i<source.length;i++){
			source[i]=(int) (Math.random()*20+1)*5;
		}
		int[] cal=new int[100];
		int[] temp=new int[100];
		System.out.println(Arrays.toString(source));
		System.out.println("**********************");
		for(int i=1;i<2;i++){
			temp=shuffle(source);
			System.out.println(Arrays.toString(temp));
			for(int m=0;m<temp.length;m++){
	
				cal[m]+=temp[m];
			}
		}
//		System.out.println(Arrays.toString(cal));
	}
	public static int[] shuffle(int[] source){
		int temp;
		int index;
		for(int i=0;i<source.length;i++){
			index=(int)(Math.random()*source.length-i)+i;
			temp=source[i];
			source[i]=source[index];
			source[index]=temp;
		}
		return source;
	}
}
