package TreeNode;



public  class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;
    public TreeNode(int x) { this.val = x; }
    public TreeNode(int [] array){
    	int lgth=array.length;
    	if(lgth==0)
    		return ;
    	TreeNode root=new TreeNode(array[0]);
    	TreeNode temp=helpbuildBinaryTree(0,array);
    	root=temp;
    	this.val=root.val;
    	this.left=root.left;
    	this.right=root.right;
    	this.root=root;
    }
    TreeNode helpbuildBinaryTree(int index,int[] array){
    		if(index>=array.length)
    			return null;
    	TreeNode temp=new TreeNode(array[index]);
    		int left=(index<<1)+1;
    		int right=(index<<1)+2;
    		temp.left=helpbuildBinaryTree(left,array);
    		temp.right=helpbuildBinaryTree(right,array);
    		return temp;
    	
    }
    public String toString(){
    	StringBuffer a= new StringBuffer();
    	helpString(a,this.root);
    	return a.toString();
    }
   private void helpString(StringBuffer a,TreeNode root){
	   if(root!=null){
		   
		   a.append(root.val+" ");
		   
		   helpString(a,root.right);
		   helpString(a,root.left);
	   }
   }
    public static void main(String[] argv){
    	int [] aa={1,2,3,4,5,6,7,8};
    	TreeNode a= new TreeNode(aa);
    	System.out.print(a);
    }
}
