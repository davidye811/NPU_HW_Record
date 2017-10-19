package communication;

public class Solution {
	public static void main(String[] argv){
		System.out.println(reverseVowels("hello"));
	}
    public static String reverseVowels(String s) {
        char[] arr  = s.toCharArray();
        char[] new_arr= new char[arr.length];
        int[] m= new int[arr.length];
        int k=0;
        for(int i =0;i< arr.length;i++){
            if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u')
                m[k++]=i;
            }
        k--;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'){
                new_arr[i]=arr[m[k--]];
            }
            else{
            new_arr[i]=arr[i];
            }
        }
        return new String(new_arr);
    }
}