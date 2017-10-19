package ShortestDistance;
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance=Integer.MAX_VALUE;
        int index1=-1,index2=-1;
        for(int i = 0;i<words.length;i++){
            if(words[i].equals(word1)){
                index1=i;
            }else if(words[i].equals(word2)){
                index2=i;
            }else{
                continue;
            }
            if(index1>=0&&index2>=0)
            distance=Math.min(distance,(index2>index1?index2-index1:index1-index2));
        }
        return distance;
    }
    public static void main(String[] argv){
    	String [] words={"a","b","c","d","d"};
    	String word1="a";
    	String word2="d";
    	
    	Solution a =new Solution();
    	System.out.println(a.shortestDistance(words, word1, word2));
    }
}