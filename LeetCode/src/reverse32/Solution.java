package reverse32;

public class Solution {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int result=0;
        for(int i = 31;i>0;i--){
            result|=(n&1)<<(i);
            n=n>>>1;
        }
        return result;
    }
    public static void main(String[] argv){
    	System.out.print(reverserBit1(1));
    }
    public static int reverserBit1(int n){
    	int result=0;
    	for(int i =0;i<31;i++){
    		result|=(n&1)<<i;
    		System.out.print((n&1)<<i);
    	}
    	return result;
    }
}