package webHelloWorldREST;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("HiHi")
public class HelloResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		
		return "Hello, Everyone!!!";
	}

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {
		return "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"utf-8\" />\r\n"
				+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "        <title>Home</title>\r\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
				+ "        <!--Bootstrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body>"
				+ "			<h1>Helo, Everyone!!!</h1>"
				+ "	   </body>"
				+ "</html>";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public University universityJson() throws FileNotFoundException {
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("University.in");
		Scanner inFile = new Scanner(inputStream);
		ArrayList<University> universities = new ArrayList<>();
		
		while(inFile.hasNext()) {
			String name = inFile.next()+" "+inFile.next();
			int year = inFile.nextInt();
			int numPrograms = inFile.nextInt();
			
			universities.add(new University(name, year, numPrograms));
		}
		inFile.close();
		
		return universities.get(0);
	}
	
	@Path("/Specify/{name}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHelloParam(@PathParam("name") String name) {
		return "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"utf-8\" />\r\n"
				+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "        <title>Home</title>\r\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
				+ "        <!--Bootstrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body>"
				+ "			<h1>Hello, Everyone from "+name+"!!!</h1>"
				+ "	   </body>"
				+ "</html>";
	}
	
	@Path("/Employee/")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello(@QueryParam("EmpID") String empId, @QueryParam("EmpName") String empName, @QueryParam("EmpSalary") double empSalary) {
		return "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"utf-8\" />\r\n"
				+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "        <title>Home</title>\r\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
				+ "        <!--Bootstrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body>"
				+ "			<h1>Helo, Everyone from Employee: "+empId+" [Name: "+empName+", Salary: "+empSalary+"] !!!</h1>"
				+ "	   </body>"
				+ "</html>";
	}
	
}
