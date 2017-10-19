import java.awt.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

class Node{
	Node leftnode;
	Node rightnode;
	int number;
	Node(int number){
		this.leftnode=null;
		this.rightnode=null;
		this.number=number;
	}
}
public class AvlTree{
	Node root;
	public AvlTree(Node root){
		this.root=root;
	}
	public void add(int newNode){
		Node NewNode=new Node(newNode);
		Node temp=root;
		while(!((temp.leftnode==null&&newNode<temp.number)||(temp.rightnode==null&&newNode>=temp.number))){
		if(newNode<temp.number){
			Node parent=temp;
			temp=temp.leftnode;
		}
			
		else{
			Node parent=temp;
			temp=temp.rightnode;
		}
		}
		if(temp.leftnode==null&&newNode<temp.number){
			temp.leftnode=NewNode;
		}
		else if(temp.rightnode==null&&newNode>=temp.number){
			temp.rightnode=NewNode;
		}
		
	}
	private void Balance_check(Node a){
		int element=tree_height(a.leftnode)-tree_height(a.rightnode);
		if(element==2){
			if(tree_height(a.leftnode.leftnode)>tree_height(a.leftnode.rightnode)){
				right_rotation(a);
			}
			else{
				left_rotation(a.leftnode);
				right_rotation(a);
			}
			}
		else if(element==-2){
			if(tree_height(a.rightnode.rightnode)>tree_height(a.rightnode.leftnode))
					left_rotation(a);
			else{
					right_rotation(a.rightnode);
					left_rotation(a);
			}
					
			
		}
	}
	private void left_rotation(Node a){
		Node temp=a.rightnode;
		a.rightnode=temp.leftnode;
		temp.leftnode=a;
		if(a==root){
			this.root=temp;
			this.root.leftnode=temp.leftnode;
			this.root.rightnode=temp.rightnode;
		}
			
	}
	private void right_rotation(Node a){
		Node temp=a.leftnode;
		a.leftnode=temp.rightnode;
		temp.rightnode=a;
		if(a==root){
			this.root=temp;
			this.root.leftnode=temp.leftnode;
			this.root.rightnode=temp.rightnode;
		}
	}
	private boolean isBalance(Node a){
		if(Math.abs(tree_height(a.leftnode)-tree_height(a.rightnode))>1)
		return false;
		if(!(isBalance(a.leftnode)&&isBalance(a.rightnode)))
			return false;
		return true;
		
	}
	private int tree_height(Node a){
		if(a==null)
			return 0;
		if(a.leftnode==null)
			return tree_height(a.rightnode)+1;
		if(a.rightnode==null)
			return tree_height(a.leftnode)+1;
		return Math.max(tree_height(a.leftnode), tree_height(a.rightnode))+1;
	}
	
	
	
	//display()
	 public String toString(){
		 StringBuilder result=new StringBuilder();
	        if(root==null){
	            System.out.println("empty tree");
	            return "";
	        }
	        ArrayDeque<Node> queue=new ArrayDeque<Node>();
	        queue.add(root);
	        while(queue.isEmpty()==false){
	            Node node=queue.remove();
	           result.append(node.number+"    ");
	            if(node.leftnode!=null){
	                queue.add(node.leftnode);
	            }
	            if(node.rightnode!=null){
	                queue.add(node.rightnode);
	            }
	         
	        }
	       result.append("\n");
	    }
	
}
