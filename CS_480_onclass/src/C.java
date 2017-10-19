interface A{
	void shape();
}
interface B{
	void shape();
}
public class C implements A,B{

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		
	}
	public static void main(){
		A c = new C();
		c.shape();
		B c1 = new C();
	}
}
