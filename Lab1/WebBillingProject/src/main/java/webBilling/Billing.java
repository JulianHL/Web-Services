package webBilling;

public class Billing {
	
	private Product product;
	private int quantity;
	public static double fed_Tax;
	public static double prv_Tax;
	
	//default constructor
	public Billing() {
		product = null;
		quantity = 0;
		fed_Tax = 0.075;
		prv_Tax = 0.06;
	}
	
	//constructor
	public Billing(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		fed_Tax = 0.075;
		prv_Tax = 0.06;
	}
	
	//getters and setters
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public static double getFed_Tax() {
		return fed_Tax;
	}
	
	public static double getPrv_Tax() {
		return prv_Tax;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static void setFed_Tax(double fed_Tax) {
		Billing.fed_Tax = fed_Tax;
	}
	
	public static void setPrv_Tax(double prv_Tax) {
		Billing.prv_Tax = prv_Tax;
	}
	
	//methods
	public double formating(double value) {
		return (double)Math.round(value * 100) / 100;
		
	}
	
	public double calculateSubTotal() {
		double subTotal = product.getProduct_price() * quantity;
		return formating(subTotal);
	}
	
	public double calculateTax() {
		double taxes = calculateSubTotal() * (fed_Tax + prv_Tax);
		return formating(taxes);
	}
	
	public double calculateBill() {
		double bill = calculateSubTotal() + calculateTax();
		return formating(bill);
	}
	

	
	

}
