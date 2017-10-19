package slot;

import java.util.Arrays;

public class Solution {
       public static void main(String[] argv){
    	   char[] w=new String("abcasdfasdf").toCharArray();
    	   char[] a=w;
    	   int b = 0;
//    	   for(;b<w.length;b++){
//    		   w[b]=(char) (w[b]&(a[(int)(b/6)]^=1<<b%6));
//    	   }
    	   String mm="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    	   for(b=0;b<a.length;b++)
				a[b]=mm.charAt(a[b]!=0?a[b]:0);

       }
}