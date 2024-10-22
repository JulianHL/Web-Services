package webFacultyREST;


import org.glassfish.jersey.client.ClientConfig;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;

public class ZipCodeRequest {

	String url = "http://api.zippopotam.us";
	
	ClientConfig config = new ClientConfig();
	Client client = ClientBuilder.newClient(config);
	WebTarget target = client.target(url);
	
	public String getZipcode(String Zipcode) {
		return target.path("/us/"+Zipcode).request().accept(MediaType.APPLICATION_JSON).get(String.class);
	}
}
