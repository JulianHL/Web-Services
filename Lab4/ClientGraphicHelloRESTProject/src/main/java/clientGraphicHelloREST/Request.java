package clientGraphicHelloREST;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;


public class Request {

	String url = "http://localhost:8080/WebHelloWorldRESTProject/rest/HiHi";
	
	ClientConfig config = new ClientConfig();
	Client client = ClientBuilder.newClient(config);
	WebTarget target = client.target(url);
	
	public String hihiJSONResponse() {
		return target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public String hihiHTMLResponse() {
		return target.request().accept(MediaType.TEXT_HTML).get(String.class);
	}
	
	public String hihiTextResponse() {
		return target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
	}
	
	public String hihiSpicifyUserResponse(String userName) {
		return target.path("/Specify/"+userName).request().accept(MediaType.TEXT_HTML).get(String.class);
	}
	
	public String hihiEmployeeResponse(String empId, String empName, double empSalary) {
		return target.queryParam("EmpID", empId).queryParam("EmpName", empName).queryParam("EmpSalary", empSalary).path("/Employee/").request().accept(MediaType.TEXT_HTML).get(String.class);
	}
}
