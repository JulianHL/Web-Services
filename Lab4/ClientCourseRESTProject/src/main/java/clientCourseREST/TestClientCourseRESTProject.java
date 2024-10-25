package clientCourseREST;

import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class TestClientCourseRESTProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "http://localhost:8080/WebCourseRESTProject/rest/WebCourse";
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(url);
		
		System.out.println("Course TEXT Output");
		String response = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(response);
		
		System.out.println("\n\nCourse HTML Output");
		response = target.request().accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(response);
		
		System.out.println("\n\nCourse JSON Output");
		System.out.print("Please enter a valid Course No: ");
		Scanner input = new Scanner(System.in);
		String course_no = input.nextLine();
		System.out.print("Please enter valid Course No: ");
		response = target.path("/searchCourse/"+course_no).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("\n"+response);
		
		System.out.println("\n\nDisplay Margin Benefits as Revenue Total Course Fees - OperatingCost");
		System.out.print("Please enter Operating Cost course for "+course_no+": ");
		double operatingCost = input.nextDouble();
		System.out.println("\n\nCourse JSON Output is: "+response);
		response = target.path("/totalCourseFees/"+course_no).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("Course Benefits Are: "+(Double.parseDouble(response)-operatingCost)+"$");
		input.close();
	}

}
