package lab3MultiThread;

class multiTimes extends Thread{ 
	private int[] array; 
	private int result;


public multiTimes(int[] array) {
	this.array = array;
}


	public void run(){ 
		result=lineCalculateResult(array,0,array.length-1);
	} 
	int lineCalculateResult(int[] sourceData,int first,int end) {
	
	if(end-first==0)
		return sourceData[first];
	int a =lineCalculateResult( sourceData,first,(first+end)/2);
	int b =lineCalculateResult( sourceData,(first+end)/2+1,end);
	return a*b;
}
	public int get_result(){
		return result;
	}
} 