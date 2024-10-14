package webBillingREST;

public class Client {

	private int client_id;
	private String client_Lname;
	private String client_Fname;
	private Billing billing;
	
	// default constructor
	public Client() {
		client_id = 0;
		client_Lname = "";
		client_Fname = "";
		billing = null;
	}
	
	// constructor
	public Client(int client_id, String client_Lname, String clent_Fname, Billing billing) {
		this.client_id = client_id;
		this.client_Lname = client_Lname;
		this.client_Fname = clent_Fname;
		this.billing = billing;
		
	}
	
	// getters and setters
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getClient_Lname() {
		return client_Lname;
	}
	public void setClient_Lname(String client_Lname) {
		this.client_Lname = client_Lname;
	}
	public String getClient_Fname() {
		return client_Fname;
	}
	public void setClient_Fname(String clent_Fname) {
		this.client_Fname = clent_Fname;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	
	//toString
	@Override
	public String toString() {
		return "client_id=" + client_id + ", client_Lname=" + client_Lname + ", client_Fname=" + client_Fname
				+ billing;
	}
}
