package webBillingREST;

public class Product {

	private String product_name;
	private double product_price;
	
	// default constructor
	public Product() {
		product_name = "";
		product_price = 0.0;
	}
	
	// constructor
	public Product(String product_name, double product_price) {
		this.product_name = product_name;
		this.product_price = product_price;
	}
	
	// getters and setters
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	
	// toString
	@Override
	public String toString() {
		return "product_name=" + product_name + ", product_price=" + product_price + "$";
	}
}
