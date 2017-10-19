package _61.RotateList;


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp;
        temp=head;
        int n=1;
        if(temp==null||k==0)
            return temp;
        while(temp.next!=null){
            temp=temp.next;
            n++;
        }
      
        temp.next=head;
        n-=k%n;
        
        while(n>0){
            n--;
            temp=temp.next;
        }
       ListNode newHead= temp.next;
        temp.next=null;
        return newHead;
    }
    public static void main(String[] argv){
    	ListNode one=new ListNode(1);
    	ListNode two = new ListNode(2);
    	one.next=two;
    	new Solution().rotateRight(one, 3);
    }
     
     
}