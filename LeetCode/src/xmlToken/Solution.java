package xmlToken;

public class Solution {
	public static void main(String[] argv){
		Solution a = new Solution();
		System.out.println(a.TokensDispaly("Name:bruce#Id:23123#Score:95"));
	}
	public static String TokensDispaly(String xml){
		StringBuffer a =new StringBuffer();
		String[] aa= xml.trim().substring(0, xml.trim().length()).split("#f|\\:");
		for(String m:aa){
			a.append(m+"\n");
		}
		return a.toString();
	}
}
