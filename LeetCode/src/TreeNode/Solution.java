package TreeNode;

import java.util.*;

public class Solution {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	  }
	public static void main(String[] argv){
		TreeNode root=new TreeNode(3);
		TreeNode a1=new TreeNode(9);
		TreeNode a2=new TreeNode(20);
		TreeNode b1=new TreeNode(15);
		TreeNode b2=new TreeNode(7);
		root.left=a1;
		root.right=a2;
		a2.left=b1;
		a2.right=b2;
		System.out.println(levelOrder(root));
	}
    public static List<List<Integer>> levelOrder(TreeNode root) {
     List<List> TreeLines =new ArrayList<List>();
     List<TreeNode> TreeLine =new  ArrayList<TreeNode>();
     if(root==null)
     return null;
     List<TreeNode> pre;
        TreeLine.add(root);
        TreeLines.add(TreeLine);
        pre=TreeLine;
        while(pre.size()!=0){
        TreeLine= new ArrayList<TreeNode>();
            for(TreeNode a:pre){
                if(a.left!=null)
                    TreeLine.add(a.left);
                if(a.right!=null)
                    TreeLine.add(a.right);
            }
            if(TreeLine.size()!=0){
                TreeLines.add(TreeLine);
               }
               pre=TreeLine;
        }
    
        List<List<Integer>> Lines =new ArrayList<List<Integer>>();
     List<Integer> Line =new  ArrayList<Integer>();
    for(List<TreeNode> mms:TreeLines){
         Line =new  ArrayList<Integer>();
        for(TreeNode mm:mms){
            Line.add(mm.val);
        }
        Lines.add(Line);
    	}
	return Lines;
    
    }
}
