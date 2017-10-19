package _537ComplexNumberMultiplication;

import java.util.Arrays;

public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aa=a.split("\\+|i");
        String[] bb= b.split("\\+|i");
        int x1=Integer.parseInt(aa[0]);
        int y1=Integer.parseInt(aa[1]);
        int x2=Integer.parseInt(bb[0]);
        int y2=Integer.parseInt(bb[1]);
        return ((x1*x2-y1*y2)+"+"+(x1*y1+x2*y2)+"i");
    }
    public static void main(String[] argv){
    	System.out.println(new Solution().complexNumberMultiply(argv[0], argv[1]));
//    	System.out.print(Arrays.toString(("1+1i").split("\\+|i")));
    }
}