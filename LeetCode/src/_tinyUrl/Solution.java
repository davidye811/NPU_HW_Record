package _tinyUrl;

import java.util.Arrays;
import java.security.MessageDigest;
public class Solution {
	char[] dictionary={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	String shortenURL(String url){
		int hash=url.hashCode();
		StringBuffer a = new StringBuffer();
		while(hash>0){
				a.append(dictionary[hash%62]);
				hash/=62;
			}
		System.out.println(a.toString());
		return url;
	}
	public static void main(String[] argv){
		new Solution().shortenURL("https://leetcode.com/problems/design-tinyurl");
	}
}
