
public class Test {
	public static void main(String[] argv){
		AvlTree newa = new AvlTree(new Node(5));
		newa.add(3);
		newa.add(2);
		newa.add(3);
		newa.add(11);
		newa.add(13);
		newa.add(25);
		newa.add(36);
		newa.add(72);
		newa.add(83);
		newa.add(25);
		System.out.println(newa);
		
	}
}
