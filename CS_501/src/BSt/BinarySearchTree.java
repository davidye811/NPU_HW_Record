package BSt;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree {
	public Node root;
	public BinarySearchTree(Node root){
		this.root=root;
	}
	public BinarySearchTree(int[] array) {
		for(int i:array){
			insert(i);
		}
	}
	public BinarySearchTree() {
		this.root=null;
	}
	public void insert(int val){
		Node insertVal=new Node(val);
		if(root==null){
			root=insertVal;
		}else{
			Node temp=root;
			Node pre = null;
			while(temp!=null){
				pre=temp;
				if(temp.val>val){
					temp=temp.left;
				}else{
					temp=temp.right;
				}
			}
			if(pre.val>val){
				pre.left=insertVal;
				insertVal.parent=pre;
			}else{
				pre.right=insertVal;
				insertVal.parent=pre;
			}
		}
	}
	public Node iterativeSearch(int val){
		Node temp=root;
		while(temp!=null&temp.val!=val){
			if(temp.val>val){
				temp=temp.left;
			}else{
				temp=temp.right;
			}
		}
		return temp;
	}
	public int successor(Node root){
		Node temp=root;
		if(temp.right!=null)
		return minimum(temp.right);
		while(temp.val<=root.val){
			temp=temp.parent;
		}
		return temp.val;
		
	}
	public int minimum(Node root){
		if(root==null)
			return Integer.MIN_VALUE;
		Node temp=root;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp.val;
	}
	public  void inorderTreeWalk(Node root){
		if(root==null)
			return ;
		
			inorderTreeWalk(root.left);
			System.out.print(root.val+" ");
			inorderTreeWalk(root.right);
	}
		public String toString(){
			List<Node> a=new ArrayList<Node>();
			
			StringBuilder sb=new StringBuilder();
			Node temp=root;
			if(root!=null)
				a.add(root);
			while(a!=null&&a.size()!=0){
				List<Node> next=new ArrayList<Node>();
				for(Node b:a){
					if(b!=null){
						sb.append(b.val+"\t");
						if(b.left!=null)
							next.add(b.left);
						if(b.right!=null)
							next.add(b.right);
					}
					
				}sb.append("\n");
				a=next;
			}
			return sb.toString();
		}
		
	
	public static void main(String[] argv){
		int[] a={15,6,18,3,7,17,20,2,4,12,8};
		BinarySearchTree T=new BinarySearchTree(a);
		System.out.print("Inorder tree walk: ");
		T.inorderTreeWalk(T.root);
		System.out.println();
		System.out.println("Minimum from node.key= 18 is "+T.minimum(T.iterativeSearch(18)));
		System.out.println("Successor to the root node is: "+(T.successor(T.root)));
		System.out.println("Successor to the node.key = 12 is "+(T.successor(T.iterativeSearch(12))));
	}
}
