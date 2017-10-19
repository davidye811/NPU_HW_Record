package LinkedList;

public class LinkedList {
	Node head;
	boolean duplicateone(){
		Node temp = head;
		int max = 0;
		while(temp!=null){
			max=(max>temp.val)? max:temp.val;
			temp=temp.next;
		}
		int[] index=new int[max+1];
		while(temp!=null){
			if(index[temp.val]==0)
			index[temp.val]++;
			else{
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] argv){
		
	}
}

class Node{
	int val;
	Node next;
}