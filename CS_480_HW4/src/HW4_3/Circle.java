package HW4_3;


public class Circle {           // save as ¡°Circle.java¡±
	// private instance variable, not accessible from outside this class
	private double radius;
	private String color;
	// 1st constructor, which sets both radius and color to default
	public Circle() {
	this.radius = 1.0;
	this.color = "red";
	}
	// 2nd constructor with given radius, but color default
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";
	}
	public Circle (double radius, String color) {
	this.radius = radius;
	this.color = color;
	}
	// A public method for retrieving the radius
	public String getColor(){
		return this.color;
	}
	public double getRadius() {
	return this.radius;
	}
	// A public method for computing the area of circle
	public double getArea() {
	return this.radius*this.radius*Math.PI;
	}
	public void setRadius(double radius) {
		this.radius = radius;
		}
	public void setColor(String color) {
		this.color=color;
	}
	public String toString(){
		return "Circle:radius="+radius+" color="+color;
	}
	}