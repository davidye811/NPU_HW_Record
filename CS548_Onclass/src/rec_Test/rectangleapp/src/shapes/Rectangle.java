package shapes;

public class Rectangle implements Comparable<Rectangle> {
	private int len;
	private int width;
	
	public Rectangle(int newWidth, int newLen) {
		width = newWidth;
		len = newLen;
	}
	
	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Rectangle otherRect = (Rectangle) obj;
		if (len != otherRect.len || width != otherRect.width) {
			return false;
		}
		
		return true;
	}

	public int getArea() {
		return len * width;
	}

	public String toString() {
		return "Rectangle["+width+","+len+"]";
	}

	public int compareTo(Rectangle otherRect) {
		int thisArea = getArea();
		int otherRectArea = otherRect.getArea();
		
		return thisArea - otherRectArea;
	}
}
