package PracticeList;
import _1StaticTools.ListNode;
public class Solution {
	ListNode head;
	public ListNode reverseList(ListNode head){
		ListNode newHead=null;
			while(head!=null){
				ListNode temp=head.next;
				head.next=newHead;
				newHead=head;
				head=temp;
			}
			return newHead;
	}
	public ListNode getHalf(ListNode head){
		ListNode newHead = null;
		newHead=head.copy(head);
		ListNode fast=newHead,slow=newHead;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			if(fast!=null)
			slow=slow.next;
		}
		slow.next=null;
		return newHead;
	}
	public ListNode mergeList(ListNode l1,ListNode l2){
		ListNode result,l3;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		result=new ListNode(0);
		l3=result;
		while(l1!=null&&l2!=null){
			l3.next=new ListNode(l1.val);
			l1=l1.next;
			l3=l3.next;
			l3.next=new ListNode(l2.val);
			l2=l2.next;
			l3=l3.next;
		}
		if(l1==null&&l2!=null){
			l3.next=l2;
		}
		if(l1!=null&&l2==null){
			l3.next=l1;
		}
		return result.next;
	}
	public void reOrder(ListNode head){
		head=mergeList(getHalf(head),reverseList(getHalf(head)));
		return ;
	}
	public static void main(String[] argv){
		int[] mm= {1,2,3,124,123,122,111};
		ListNode a= new ListNode(mm);
//		ListNode temp=new ListNode(mm);
//		ListNode b=new Solution().getHalf(new Solution().reverseList(temp));
//		System.out.println(new Solution().mergeList(new Solution().getHalf(a),b));
		ListNode temp=new Solution().getHalf(a);
		System.out.println(temp);
	}
}
