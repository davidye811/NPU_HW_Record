package lab3MultiThreadPlus;

public class myThread extends Thread{
	
	private static int[][] source;
	private static int[] result;
	public myThread(int[][] source){
		this.source=source;
		this.result=new int[source.length];
	}
	public int[] getResult() {
		return result;
	}
	public void setResult(int i,int j) {
		this.result[i]=j;
	}
	public int[][] getSource() {
		return source;
	}
	public void setSource(int[][] source) {
		this.source = source;
	}
	public void run(){
		for(int i =0;i<source.length;i++){
			if(result[i]==0){
		//		System.out.println(i);
				result[i]=1;
				result[i]=lineCalculateResult(source[i],0,source[i].length-1);
			}
		}
	}
	 int lineCalculateResult(int[] sourceData,int first,int end) {
			
			if(end-first==0)
				return sourceData[first];
			int a =lineCalculateResult( sourceData,first,(first+end)/2);
			int b =lineCalculateResult( sourceData,(first+end)/2+1,end);
			return a*b;
		}
	
}
