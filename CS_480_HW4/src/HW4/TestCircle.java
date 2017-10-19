package HW4;

public class TestCircle {        // save as "TestCircle.java"           
	   public static void main(String[] args) {
	Circle c1 ; // Declare and allocate an instance of class Circle called c1 with default radius and color
	c1= new Circle();// Use  1st constructor, // which sets both radius and color to default
	 
	System.out.println("Radius:"+c1.getRadius());      // Use the dot operator to invoke methods of instance c1 and print the method results.
	System.out.println("Area:"+c1.getArea());
	Circle c2;// Declare and allocate an instance of class circle called c2 with the given radius and default color
	c2=new Circle(2.0);// Use 2nd constructor with given radius, but color default.
	System.out.println("Radius:"+c2.getRadius());      // Use the dot operator to invoke methods of instance c2.
	System.out.println("Area:"+c2.getArea());
	   }
	}