package clientCarREST;

import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;

public class TestClientCarREST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "http://localhost:8080/WebCarRESTProject/rest/WebCar";
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(url);
		
		String response = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		System.out.println("Car TEXT Output:");
		System.out.println(response);
		
		response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("CarList JSON Output:");
		System.out.println(response);
		
		Scanner input = new Scanner(System.in);
		
		
		do {
		System.out.print("\nPlease enter valid car VIN: ");
		
		response = target.path("/searchCar/"+input.next()).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("\nCar JSON Search Output:");
		System.out.println(response);
		
		System.out.print("\nDo you want to continue y/n: ");
		}while(input.next().equals("y"));
		
		
		System.out.println("\nDisplay Margin Benefits as Revenue Total Discount - Total Operting Car Cost");
		System.out.print("Please enter Total Operating Car Cost: ");
		double OperatingCarCost = input.nextDouble();
		response = target.path("/TotalCarPriceDiscount").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println("\nTotal Car Price Discount Output is:"+response+"$");
		System.out.println("Car Benefits are:"+(Double.parseDouble(response)-OperatingCarCost)+"$");
		input.close();
	}
}
