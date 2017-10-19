package List;



public class Solution {
	   
	 public static void main(String[] argv){
		 ListNode a=new ListNode(0);
		 a.next=new ListNode(1);
		 ListNode temp=a;
		 temp=temp.next;
		 temp.next=new ListNode(2);
		 temp=temp.next;
		 temp.next=new ListNode(3);
		 Solution mm=new Solution();
		 ListNode reverseone=mm.reverse(a);
		 while(reverseone!=null){
			 System.out.print(reverseone.val+" ");
		 reverseone=reverseone.next;
		 }
	 }
    public void reorderList(ListNode head) {
       
        
    }
    public ListNode reverse(ListNode head){
      ListNode newHead;
      ListN 												
      while(head!=null){
    	  
      }
    }
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}