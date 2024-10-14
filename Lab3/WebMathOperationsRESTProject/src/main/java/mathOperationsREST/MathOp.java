package mathOperationsREST;

public class MathOp {
	
	private double x;
	private double y;
	private double z;
	
	//Default constructor
	public MathOp() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	//Constructor
	public MathOp(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//Getters and setters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	//toStirng
	@Override
	public String toString() {
		return "MathOp [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	
	//Methods
	public double calculateSum() {
		return x+2*y+3*z;
	}
	
	public double calculatePrd() {
		return x*2*y*3*z;
	}

}
