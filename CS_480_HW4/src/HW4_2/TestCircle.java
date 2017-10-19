package HW4_2;

public class TestCircle {
	public static void main(String[] argv){
	Circle c3 = new Circle();   // construct an instance of Circle
	c3.setRadius(5.0);          // change radius
	c3.setColor("black");           // change color
	System.out.println("Area:"+c3.getArea());
	System.out.println("Color:"+c3.getColor());
	System.out.println("Radius:"+c3.getRadius());
	}
}
