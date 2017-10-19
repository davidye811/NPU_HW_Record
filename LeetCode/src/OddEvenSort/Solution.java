package OddEvenSort;
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        ListNode resultodd = new ListNode(0);
        ListNode resulteven = new ListNode(0);
        ListNode temp = head;
        ListNode temp1=resultodd;
        ListNode temp2=resulteven;
        int n=0;
        while(temp!=null){
            if((n&1)==0){
                resultodd.next=new ListNode(temp.val);
                resultodd=resultodd.next;
            }else if((n&1)==1){
                resulteven.next=new ListNode(temp.val);
                resulteven=resulteven.next;
            }
            n=(n+1);
            temp=temp.next;
        }
        resultodd=temp2.next;
        return temp1.next;
        }
    public static void main(String[] argv){
    	ListNode head=new ListNode(0);
    	ListNode temp=head;
    	for(int i =  1 ;i<8;i++){
    		temp.next=new ListNode(i);
    		temp=temp.next;
    		
    	}
    	Solution a = new Solution();
    	a.oddEvenList(head);
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

 