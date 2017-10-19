package lab3;



public class calculateMultiMetrix2 {
	public static void main(String[] argv){
		int[][] a={{1,2},{2,3}};
		calculateMultiMetrix2 mm=new calculateMultiMetrix2();
		System.out.println(mm.result(a));
	}
	public int[] result(int[][] sourceData){
		int[] result =new int[sourceData.length];
		for(int i =0;i<sourceData.length;i++){
			result[i]=lineCalculateResult(sourceData[i],0,sourceData[i].length);
		}
		return result;
	}
	 int lineCalculateResult(int[] sourceData,int first,int end) {
		
		if(end-first==0)
			return sourceData[first];
		int a =lineCalculateResult( sourceData,first,(first+end)/2);
		int b =lineCalculateResult( sourceData,(first+end)/2+1,end);
		return a*b;
	}
	
}
