package clientMyHelloREST;


import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;


public class App 
{
    public static void main( String[] args )
    {
		String url = "https://api.zippopotam.us";
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(url);
		
		/*System.out.println("JSON consume:");
		String response = target.request()
								.accept(MediaType.APPLICATION_JSON)
								.get(String.class);
		System.out.println(response);
		
		System.out.println("\nHTML consume:");
		response = target.request()
						 .accept(MediaType.TEXT_HTML)
						 .get(String.class);
		System.out.println(response);
		
		System.out.println("\nHTML Path consume:");
		Scanner Input = new Scanner(System.in);
		System.out.println("Introduce a name:");
		response = target.path("/Specify/"+Input.next()).request()
						 .accept(MediaType.TEXT_HTML)
						 .get(String.class);
		System.out.println("\n"+response);
		
		System.out.println("\nHTML QueryParams consume:");
		System.out.println("Introduce EmpId:");
		String EmpId = Input.next();
		System.out.println("Introduce EmpName:");
		String EmpName = Input.next();
		System.out.println("Introduce EmpSalary:");
		Double EmpSalary = Input.nextDouble();
		response = target.queryParam("EmpID", EmpId).queryParam("EmpName", EmpName).queryParam("EmpSalary", EmpSalary).path("/Employee/").request()
						 .accept(MediaType.TEXT_HTML)
						 .get(String.class);
		System.out.println("\n"+response);
		
		url = "https://api.zippopotam.us/us";
		target = client.target(url);
		System.out.println("\nHTML API consume:");
		System.out.println("Introduce a ZIPCODE:");
		response = target.path("/"+Input.nextInt()).request()
						 .accept(MediaType.APPLICATION_JSON)
						 .get(String.class);
		Input.close();
		System.out.println("\n"+response);
		*/
		
		System.out.print(target.path("/us/"+"90210").request().accept(MediaType.APPLICATION_JSON).get(String.class));
		
		
		
    }
}
