package T1;

import java.util.ArrayList;
import java.util.List;

public class StringCombo {
		public StringCombo() {
		// TODO Auto-generated constructor stub
	}
		public int count(String s,String b){
			StringBuffer ss=new StringBuffer(s);
			int count =0;
			while(ss.indexOf(b)!=-1){
				ss=new StringBuffer(ss.substring(ss.indexOf(b)+b.length()));
				count++;
			}
			return count;
		}
		public List<String> result(String s,List<String> a){
			StringBuffer ss=new StringBuffer(s);
			if(ss==null){
				return new ArrayList<String>();
			}
			if(ss.length()==1){
				a.add(ss.toString());
				return a;
			}
			List<String> pre= result(ss.substring(1),new ArrayList<String>());
			for(int i=0;i<pre.size();i++){
				for(int j=0;j<=pre.get(i).length();j++){
					StringBuffer mm=new StringBuffer();
					mm.append(pre.get(i).substring(0,j));
					mm.append(ss.charAt(0));
					mm.append(pre.get(i).substring(j));
					if(!a.contains(mm.toString()))
					a.add(mm.toString());
				}
			}
			return a;
		}
		public String reverse(String s){
			StringBuffer a=new StringBuffer();
			for(int i = s.length()-1;i>=0;i--)
			a.append(s.charAt(i));
			return a.toString();
			
		}
		public void Upper_print(String s){
			StringBuffer ss= new StringBuffer(s.toUpperCase());
			for(int i = 0; i<ss.length();i++){
				System.out.println(ss.charAt(i));
				System.out.println();
			}
		}
		
}
