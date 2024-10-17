package rectangleGUI;

public class Rectangle {
	
	private double width;
	private double length;
	
	//Constructor
	public Rectangle()
	{
		width = 0.0;
		length = 0.0;
	}
	
	public Rectangle(double width, double length)
	{
		this.width = width;
		this.length = length;
	}

	//Getters and Setters
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	//Methods
	public double area() 
	{
		return width * length;
	}
	
	public double perimeter() 
	{
		return 2*(width*length);
	}
	

}
