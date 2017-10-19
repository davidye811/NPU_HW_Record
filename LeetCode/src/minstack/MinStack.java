package minstack;

	public class MinStack {
	    class elem{
	        int num;
	        elem next;
	        elem(int num,elem next){
	            this.num=num;
	            this.next=next;
	        }
	    }
	    /** initialize your data structure here. */
	        elem top;
	        int min;
	    public MinStack() {
	         this.top=null;
	    }
	    
	    public void push(int x) {
	        if(this.top==null){
	            top=new elem(x,null);
	            min=x;
	        }else{
	            elem temp=top;
	            top=new elem(x,temp);
	            if(x<min)
	            min=x;
	        }
	    }
	    
	    public void pop() {
	            top=top.next;
	            if(top.num==min)
	                min=getMin();
	    }
	    
	    public int top() {
	            return top.num;
	    }
	    
	    public int getMin() {
	            int mini=top.num;
	            elem temp = top;
	            while(temp.next!=null){
	                temp=temp.next;
	                if(mini>=temp.num)
	                    mini=temp.num;
	            }
	            return mini;
	    }
	}


	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */