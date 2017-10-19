package _567.permution;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] record = new int[26];
        for(int i = 0 ;i<s1.length();i++){
            record[s1.charAt(i)-'a']++;
        }
        for(int i = 0 ; i <=s2.length()-s1.length();i++){
            int[] record2 = new int[26];
            for(int j=i;j<i+s1.length();j++){
                record2[s2.charAt(j)-'a']++;
            }
            if(ArrayComp(record,record2)) 
                return true;
        }
        return false;
       
    }
    
    boolean ArrayComp(int[] array1,int[] array2){
        for(int i = 0 ; i<array1.length;i++){
            if(array1[i]!=array2[i])
                return false;
        }
        return true;
    }
    public static void main (String [] argv){
    	System.out.print(new Solution().checkInclusion("adc","dcda"));
    }
}