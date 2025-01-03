package webBilling;

public class Client {

	private String client_Lname;
	private String clent_Fname;
	private Billing billing;
	
	// default constructor
	public Client() {
		client_Lname = "";
		clent_Fname = "";
		billing = null;
	}
	
	// constructor
	public Client(String client_Lname, String clent_Fname, Billing billing) {
		super();
		this.client_Lname = client_Lname;
		this.clent_Fname = clent_Fname;
		this.billing = billing;
		
	}
	
	// getters and setters
	public String getClient_Lname() {
		return client_Lname;
	}
	public void setClient_Lname(String client_Lname) {
		this.client_Lname = client_Lname;
	}
	public String getClent_Fname() {
		return clent_Fname;
	}
	public void setClent_Fname(String clent_Fname) {
		this.clent_Fname = clent_Fname;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
}
