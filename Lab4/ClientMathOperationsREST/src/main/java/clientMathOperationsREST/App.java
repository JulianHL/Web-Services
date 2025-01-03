package clientMathOperationsREST;

import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "http://localhost:8080/WebMathOperationsRESTProject/rest/MathOp";
        
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(url);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter x: ");
        double x = input.nextDouble();
        System.out.print("Please, enter y: ");
        double y = input.nextDouble();
        System.out.print("Please, enter z: ");
        double z = input.nextDouble();
        
        System.out.println("\n--- Consume MathOp for x: " + x + " y: " + y + " z: " + z+": ---\n");
        String response = target.queryParam("x", x).queryParam("y", y).queryParam("z", z).request().accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(response);
		
		System.out.println("\n--- Consume MathOp/listArray: ---\n");
		response = target.path("/listArray").request().accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(response);
		
		
		System.out.println("\n--- Consume MathOp/OpHashMap/{x}: ---\n");
		System.out.print("Enter a number to search into the HashMap: ");
		response = target.path("/OpHashMap/"+input.nextDouble()).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("\n"+response);
		input.close();
		

        
	
    }
}
