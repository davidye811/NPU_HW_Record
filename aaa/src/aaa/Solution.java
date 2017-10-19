package aaa;

import java.util.*;

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return ;
        List<List> structree = new ArrayList<List>();
        List<TreeLinkNode> line = new ArrayList<TreeLinkNode>();
        List<TreeLinkNode> pre = new ArrayList<TreeLinkNode>();
        line.add(root);
        structree.add(line);
        pre=line;
        while(pre.size()!=0){
            line=new ArrayList<TreeLinkNode>();
            for(TreeLinkNode m:pre){
                if(m!=null){
                	if(m.left!=null)
            line.add(m.left);
                	if(m.right!=null)
            line.add(m.right);
                }
            }
            structree.add(line);
            pre=line;
        }
        for(List<TreeLinkNode> m:structree){
            for(int i=0;i<m.size()-1;i++){
                m.get(i).next=m.get(i+1);
            }
        }
    }
    public static void main(String[] argv){
    	Solution a = new Solution();
    	a.connect(new TreeLinkNode(0));
    }
}

   class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
 