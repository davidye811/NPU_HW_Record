
public class BstTree{
	public static void main(String[] argv){
		int [] a={3,1,4,0,2};
		BstTree bsttree=new BstTree();
		bsttree.putArraysIn(a);
		System.out.println(bsttree);
	}
	TreeNode root;
		public BstTree(){
			
		}
		public void putArraysIn(int[] array){
			for(int i = 0;i<array.length;i++){
				if(i==0){
					root=new TreeNode(array[i]);
					continue;
				}else{
					int pre=array[(i-1)>>1];
					TreeNode temp=root;
					while(temp.val!=pre){
						if(temp.val<pre){
							temp=temp.right;
						}else{
							temp=temp.left;
						}
					}
					if((i&1)==0){
						temp.right=new TreeNode(array[i]);
					}else{
						temp.left=new TreeNode(array[i]);
					}
				}
			}
		}
		public String toStringHelp(TreeNode root){
			if(root==null)
				return "";
			return root.val+" "+toStringHelp(root.left)+" "+toStringHelp(root.right);
		}
		public String toString(){
			return toStringHelp(root);
			
		}
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		 TreeNode(int x) { val = x; }
		
	}
	
}
