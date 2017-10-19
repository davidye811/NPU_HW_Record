package _314.Binary_Veritical;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer,List> result = new TreeMap<Integer,List>();
        putIntoMap(root,0,result);
		return null;
    }
    void putIntoMap(TreeNode root,int col,Map<Integer,List> result){
        List<TreeNode> a = result.get(col);
        a.add(root);
        result.put(col,a);
        putIntoMap(root.left,col-1,result);
        putIntoMap(root.left,col+1,result);
    }
 
    public class TreeNode {
    	     int val;
    	      TreeNode left;
    	     TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
   	 
}