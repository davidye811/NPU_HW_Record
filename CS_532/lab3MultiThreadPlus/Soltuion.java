package lab3MultiThreadPlus;

import java.util.Arrays;

public class Soltuion {
	public static void main(String[] argv){
		NumGenerator numGenerator =new NumGenerator(20);
		long startTime=System.nanoTime();
		long endTime;
		final  int[][] souce =new int[20000][20];
		for(int i =0;i<souce.length;i++){
			for(int j=0;j<souce[i].length;j++){
				souce[i][j]=(numGenerator.retrieveRandomNum()+1)%5+1;
			}
		}
		//for(int[] m:souce){
		//System.out.println(Arrays.toString(m));
		//}
		myThread a =new myThread(souce);
		//myThread b =new myThread(souce);
		for(int i =0;i<1;i++){
			
			new Thread(a).start();
		}
		
		//new Thread(a).start();
		//new Thread(a).start();
		//new Thread(a).start();
		try {
			a.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println((System.nanoTime()-startTime)/1000000);
		System.out.println(Arrays.toString(a.getResult()));
	}
}
