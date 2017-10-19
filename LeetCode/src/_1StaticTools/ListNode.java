package _1StaticTools;

public class ListNode implements Cloneable{
	public int val;
	public ListNode next;
	public ListNode(int a){
		this.val=a;
	}
	public ListNode(int[] x){
		if(x==null||x.length==0)
			return ;
		ListNode temp=ListNodeNext(x,0);
		this.val=temp.val;
		this.next=temp.next;
	}
	public ListNode ListNodeNext(int[] x,int a){
		if(a>x.length-1){
			return null;
		}
		ListNode temp=new ListNode(x[a]);
		temp.next=ListNodeNext(x,a+1);
		return temp;
		
	}
	
	public String toString(){
		StringBuffer a = new StringBuffer();
		ListNode temp=this;
		while(temp!=null){
			a.append(temp.val);
			if(temp.next!=null){
				a.append("->");
			}
			temp=temp.next;
		}
		return a.toString();
		
	}
	public ListNode copy(ListNode head){
		if(head==null)
			return null;
			ListNode l1,l2;
			l2=head;
			l1=new ListNode(l2.val);
			l1.next=copy(l2.next);
		return l1;

	}
}
