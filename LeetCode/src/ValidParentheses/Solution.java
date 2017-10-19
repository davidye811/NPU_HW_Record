package ValidParentheses;

import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> a=new Stack<Character>();
        char[] mm=s.toCharArray();
        for(int i=0;i<mm.length;i++){
            switch(mm[i]){
                case '(':{a.push('(');break;}
                case ')':{if(a.empty())
                            return false;
                            if(a.pop()!='(')
                            return false;
                            break;}
                case '{':{a.push('{');break;}
                case '}':{if(a.empty())
                            return false;
                            if(a.pop()!='{')
                            return false;
                            break;}
                case '[':{a.push('[');break;}
                case ']':{if(a.empty())
                            return false;
                            if(a.pop()!='[')
                            return false;
                            break;}
                
            }
            
            
        }
        if(!a.empty())
                return false;
            return true;
    }
    public static void main(String[] argv){
    	System.out.println(isValid("()[]{}"));
    }
}