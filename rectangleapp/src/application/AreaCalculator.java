package application;

import shapes.Rectangle;

public class AreaCalculator {
	public static void main(String arg[]) {
		Rectangle rect1, rect2;
		int compareRslt;
		
		rect1 = new Rectangle(5, 10);
		rect2 = new Rectangle(4, 4);
		
		System.out.println("Area of rect1: " + rect1.getArea());
		if (rect1.equals(rect2)) {
			System.out.println("Rectangles are equal");
		} else {
			System.out.println("Rectangles are not equal");
		}
		
		compareRslt = rect1.compareTo(rect2);
		if (compareRslt > 0) {
			System.out.println("rect1 is larger");
		} else if (compareRslt < 0){
			System.out.println("rect1 is smaller");
		} else {
			System.out.println("rect1 and rect2 are the same size");
		}
		
		System.out.println(rect1);
	}

}
