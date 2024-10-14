package mathOperationsREST;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/MathOp")
public class WebMathResource {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String calculateHTMLOp(@QueryParam("x") double x, @QueryParam("y") double y, @QueryParam("z") double z){
		
		MathOp mathOp = new MathOp(x,y,z);
		return"<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"UTF-8\" />\r\n"
				+ "        <title>MathOperations</title>\r\n"
				+ "        <!--BoostTrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body onload=\"fetchIpInfo()\">\r\n"
				+ "        <label id=\"sumlabel\" for=\"sum\" class=\"fw-bolder\">Calculate ((x+2)*(y+3)*z) Output is:</label>\r\n"
				+ "        <label id=\"sum\">"+mathOp.calculateSum()+"</label>\r\n"
				+ "		   <br>\r\n"
				+ "        <label label id=\"prdlabel\" for=\"prd\" class=\"fw-bolder\">Calculate (x*2*y*3*z) Output is:</label>\r\n"
				+ "        <label id=\"prd\">"+mathOp.calculatePrd()+"</label>\r\n"
				+ "\r\n"
				+ "        <!--BoostTrap JS-->\r\n"
				+ "        <script\r\n"
				+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n"
				+ "            crossorigin=\"anonymous\"></script>\r\n"
				+ "        <!--js-->\r\n"
				+ "        <script>\r\n"
				+ "            async function fetchIpInfo() {\r\n"
				+ "                const url = \"http://localhost:8080/WebMathOperationsRESTProject/rest/MathOp?x="+x+"&y="+y+"&z="+z+"\";\r\n"
				+ "\r\n"
				+ "                const response = await fetch(url);\r\n"
				+ "\r\n"
				+ "                if (!response.ok) {\r\n"
				+ "                    throw new Error(`HTTP error! Status: ${response.status}`);\r\n"
				+ "                }\r\n"
				+ "\r\n"
				+ "                var json = await response.json();\r\n"
				+ "                document.getElementById(\"sumlabel\").innerText =\r\n"
				+ "                    \"Calculate ((\" + json.x + \"+2)*(\" + json.y + \"+3)*\" + json.z + \") Output is:\";\r\n"
				+ "                document.getElementById(\"prdlabel\").innerText =\r\n"
				+ "                    \"Calculate ((\" + json.x + \"*2)*(\" + json.y + \"*3)*\" + json.z + \") Output is:\";\r\n"
				+ "            }\r\n"
				+ "        </script>\r\n"
				+ "    </body>\r\n"
				+ "</html>";
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MathOp displayXYZJSON(@QueryParam("x") double x, @QueryParam("y") double y, @QueryParam("z") double z){
		return new MathOp(x,y,z);
	}
	
	@Path("/listArray")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayXYZXML(){
		ArrayList<MathOp> mathOpList = new ArrayList<MathOp>();
		mathOpList.add(new MathOp(1,2,3));
		mathOpList.add(new MathOp(4,5,6));
		mathOpList.add(new MathOp(7,8,9));
		String result = "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"UTF-8\" />\r\n"
				+ "        <title>MathOperations</title>\r\n"
				+ "        <!--BoostTrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "	   <body onload=\"fetchIpInfo()\">"
				+ " 	<h1>ListXYZ Array List:</h1>"
				+ " 	<br>";
		for(int i = 0; i < mathOpList.size(); i++){
			
			result += "\r\n		   <h1>ArrayList Element: "+i+":"+mathOpList.get(i)+"<h1>";
		}
		
		result += "\r\n"
				+ "		   <!--BoostTrap JS-->\r\n"
				+ "        <script\r\n"
				+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n"
				+ "            crossorigin=\"anonymous\"></script>\r\n"
				+ "    </body>\r\n"
				+ "</html>";
		
		return result;
	}
	
	@Path("/OpHashMap/{x}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MathOp searchHashMapListZYZ(@PathParam("x")double x){
		HashMap<Double,MathOp> mathOpList = new HashMap<Double,MathOp>();
		MathOp mathOp = new MathOp(1,2,3);
		mathOpList.put(mathOp.getX(), mathOp);
		mathOp = new MathOp(4,5,6);
		mathOpList.put(mathOp.getX(), mathOp);
		mathOp = new MathOp(7,8,9);
		mathOpList.put(mathOp.getX(), mathOp);
		return mathOpList.get(x);
	}
}
