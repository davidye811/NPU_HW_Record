package SortList;

public class Solution {

	public static void main(String[] argv){
		ListNode a=new ListNode(2);
		a.next=new ListNode(1);
		Solution ab =new Solution();
		ab.toString(ab.sortList(a));
	}
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode temp1;
        ListNode middle =midfind(head);
        temp1=middle.next;
        middle.next=null;
        return mergeList(sortList(head),sortList(temp1));
    }
    public ListNode midfind(ListNode head){
        ListNode slow= head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeList(ListNode fir,ListNode sec){
        ListNode result = new ListNode(0);
        ListNode newHead=result;
        if(fir==null)
            return sec;
        if(sec==null)
            return fir;
        while(fir!=null&&sec!=null){
            if(fir.val<=sec.val){
                result.next=fir;
                fir=fir.next;
            }else{
                result.next=sec;
                sec=sec.next;
            }
            result=result.next;
        }
        while(fir==null&&sec!=null){
             result.next=sec;
                sec=sec.next;
                result=result.next;
        }
        while(fir!=null&&sec==null){
             result.next=fir;
                fir=fir.next;
                result=result.next;
        }
        return newHead.next;
    }
    public void toString(ListNode head){
    	while(head!=null){
    		System.out.println(head.val+" ");
    		head=head.next;
    	}
    	
    }
}
 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }