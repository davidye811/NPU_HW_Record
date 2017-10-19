package _230KthSmallestElementInBST;


public class Solution {
	
    public int kthSmallest(TreeNode root, int k) {
        TreeNode temp=root;
        while(temp.left!=null){
            temp=temp.left;
        }
        while(--k>0){
            temp=successor(root,temp);
        }
        return temp.val;
    }
    TreeNode successor(TreeNode root,TreeNode a){
        TreeNode temp=root;
        TreeNode pre=root;
       if(a.right!=null){
           pre=a.right;
            while(pre.left!=null){
           pre=pre.left;
        }
       return pre;
       }
       if(a==root){
           return null;
       }
       while(temp!=a){
           pre=temp;
           if(a.val<temp.val){
               temp=temp.left;
           }else{
               temp=temp.right;
           }
       }
      
      return pre;
}
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
}