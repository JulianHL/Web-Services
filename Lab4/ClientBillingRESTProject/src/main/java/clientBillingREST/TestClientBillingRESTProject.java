package clientBillingREST;

import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class TestClientBillingRESTProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url ="http://localhost:8080/WebBillingRESTProject/rest/WebBilling";
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(url);
		
		System.out.println("Billing TEXT Output");
		String response = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(response);
		
		System.out.println("\n\nBilling HTML Output");
		response = target.request().accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(response);
		
		
		
		System.out.println("\n\nBilling JSON Output");
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter numerical Client ID: ");
		response = target.path("/searchBilling/"+input.nextInt()).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("\n"+response);
		input.close();
	}
	


}
