package BSt;

public class Node {
	
	public int val;
	public Node left;
	public Node right;
	public Node parent;
	public Node(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}
	public String toString(){
		return val+"";
	}
}
