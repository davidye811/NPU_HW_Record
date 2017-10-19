package _87;

public class Solution {
    public String reverseStr(String s, int k) {
        if(k==0)
            return s;
        
        char[] c=s.toCharArray();
        if(k>s.length()){
            for(int i=0;i<c.length/2;i++){
                 swap(c,i,c.length-i-1);
             }
        }else{
        for(int i=0;i<c.length;i++){
             if((i)%(2*k)<k/2&&i+k-2*(i%k)-1<s.length()){
                 swap(c,i,i+k-2*(i%k)-1);
             }
        }
        }
        return new String(c);
    }
    private void swap(char[] array, int i ,int j){
        char temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void main(String[] argv){
    	System.out.print(new Solution().reverseStr("abcdefg",
    			8));
    }
}
