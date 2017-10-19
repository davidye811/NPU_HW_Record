package rodCuttingProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class RodCuttingProblem {
	static int countRecurisiveCalledwithoutMemorized=0;
	static int countRecurisiveCalledwithMemorized=0;
	static ArrayList<Integer> piecesResult;
	static int  currentLenth;
	static int[] price={1,5,8,9,10,17,17,20,24,30};
	static int[] firstPiece;
	int cutRod(int num){
		countRecurisiveCalledwithoutMemorized++;
		if(num==0)
			return 0;
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=10;i++){
			if(num-i>=0){
				max=Math.max(max, cutRod(num-i)+price[i-1]);
			}
		}
		return max;
	}
int a = Integer.MAX_VALUE ;
	public int memoizedCutRodAux(int[] bestpriceStored, int num){
		countRecurisiveCalledwithMemorized++;
			if(num==0)
				return 0;
			if(bestpriceStored[num]!=Integer.MIN_VALUE){
				return bestpriceStored[num];
			}
			int signal=0;
			for(int i=1;i<=10;i++){
				if(num-i>=0){
					int memo=memoizedCutRodAux(bestpriceStored,num-i)+price[i-1];
					if(bestpriceStored[num]<memo){
						bestpriceStored[num]=memo;
						signal=i;
					}
					//bestpriceStored[num]=Math.max(bestpriceStored[num], memoizedCutRodAux(bestpriceStored,num-i)+price[i-1]);
				}
			}
			firstPiece[num]=signal;
			return bestpriceStored[num];
		}
	public int memoizedCutRod(int num){
		piecesResult=new ArrayList<Integer>();
		int[] bestpriceStored= new int[num+1];
		Arrays.fill(bestpriceStored,Integer.MIN_VALUE);
		 firstPiece= new int[num+1];
		return memoizedCutRodAux(bestpriceStored,num);
	}
	public static void main(String[] argv){
		RodCuttingProblem a = new RodCuttingProblem();
		System.out.println("Length\tRev CR\tNum Calls CR\tRev MCR\tNum Calls MCR\tCut Pieces");
		for(int i = 1;i<=10;i++){
		System.out.print(i+"\t");
			System.out.print(a.cutRod(i)+"\t");
			System.out.print(a.countRecurisiveCalledwithoutMemorized+"\t\t");
			System.out.print(a.memoizedCutRod(i)+"\t");
			System.out.print(a.countRecurisiveCalledwithMemorized);
			int number=i;
			System.out.print("\t\t");
			while(number>0){
				System.out.print(" "+firstPiece[number]);
				number-=firstPiece[number];
			}
				System.out.println();
			a.countRecurisiveCalledwithMemorized=0;
			a.countRecurisiveCalledwithoutMemorized=0;
			}
	}
}
