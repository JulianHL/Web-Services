package webBillingREST;

import java.io.InputStream;
import java.util.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/WebBilling")
public class WebBillingResource {
	
	private List<Client> billingList;
	
public void fillArrayList() {
	billingList = new ArrayList<>();
	InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Billing.in");
	Scanner inFile = new Scanner(inputStream);
	
	while(inFile.hasNext()) {
		int client_id = inFile.nextInt();
		String client_Lname = inFile.next();
		String client_fname = inFile.next();
		String product_name = inFile.next();
		double product_price = inFile.nextDouble();
		int quantity = inFile.nextInt();
		
		
		Product product = new Product();
		Billing billing = new Billing();
		Client client = new Client();
		
		
		client.setClient_id(client_id);
		client.setClient_Lname(client_Lname);
		client.setClient_Fname(client_fname);
		product.setProduct_name(product_name);
		product.setProduct_price(product_price);
		billing.setQuantity(quantity);
		billing.setProduct(product);
		client.setBilling(billing);
		billingList.add(client);
	}
	
	inFile.close();
}
	
	
@GET
@Produces(MediaType.TEXT_HTML)
public String displayHTMLBillingInfo() {
	
	fillArrayList();
	String html = "<!doctype html>\r\n"
			+ "<html lang=\"en\">\r\n"
			+ "    <head>\r\n"
			+ "        <meta charset=\"UTF-8\" />\r\n"
			+ "        <title>Billing</title>\r\n"
			+ "        <!--BoostTrap CSS -->\r\n"
			+ "        <link\r\n"
			+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
			+ "            rel=\"stylesheet\"\r\n"
			+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
			+ "            crossorigin=\"anonymous\" />\r\n"
			+ "    </head>\r\n"
			+ "    <body>\r\n"
			+ "        <table class=\"table\">\r\n"
			+ "            <thead class=\"table-dark\">\r\n"
			+ "                <tr>\r\n"
			+ "                    <th scope=\"col\">client_Id</th>\r\n"
			+ "                    <th scope=\"col\">client_LName</th>\r\n"
			+ "                    <th scope=\"col\">client_FName</th>\r\n"
			+ "                    <th scope=\"col\">product_Name</th>\r\n"
			+ "                    <th scope=\"col\">prd_Price</th>\r\n"
			+ "                    <th scope=\"col\">prd_Qty</th>\r\n"
			+ "                    <th scope=\"col\">Total Billing</th>\r\n"
			+ "                </tr>\r\n"
			+ "            </thead>\r\n"
			+ "            <tbody>";
	double totalBills = 0;
	for(Client client : billingList) {
		html += "<tr>"
			 + "<th scope=\"row\">" + client.getClient_id() + "</th>"
			 + "<td>" + client.getClient_Lname() + "</td>"
			 + "<td>" + client.getClient_Fname() + "</td>"
			 + "<td>" + client.getBilling().getProduct().getProduct_name() + "</td>"
			 + "<td>" + client.getBilling().getProduct().getProduct_price() + "$</td>"
			 + "<td>" + client.getBilling().getQuantity() + "</td>"
			 + "<td>" + client.getBilling().calculateBill() + "$</td>"
			 + "</tr>";
		totalBills += client.getBilling().calculateBill();
	}
	
	html += "            </tbody>\r\n"
			+ "        </table>\r\n"
			+ "		   <h1>The Total of Billing is: " + totalBills + "$</h1>"
			+ "\r\n"
			+ "        <!--BoostTrap JS-->\r\n"
			+ "        <script\r\n"
			+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n"
			+ "            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n"
			+ "            crossorigin=\"anonymous\"></script>\r\n"
			+ "    </body>\r\n"
			+ "</html>";
	return html;
}

@GET
@Produces(MediaType.TEXT_PLAIN)
public String displayTextBillingInfo() {
	
	fillArrayList();
	String result = "";
	double totalBills = 0;
	for(int i = 0; i<billingList.size(); i++) {
		
		Client client = billingList.get(i);
		result+= client + "\n";
		totalBills += client.getBilling().calculateBill();
	}
	
	result += "\nThe Total of Billing is: " + totalBills + "$";
	return result;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/searchBilling/{client_id}")
public Client searchJSONBillingInfo( @PathParam("client_id") int client_id) {
	fillArrayList();
	Client result = null;
	
	if(billingList != null && !billingList.isEmpty()) {
		for(Client client : billingList) {
			if (client.getClient_id() == client_id) {
				result = client;
				return result;
			}
		}
		
	}
	return result;
}


}
