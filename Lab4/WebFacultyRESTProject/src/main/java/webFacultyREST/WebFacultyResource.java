package webFacultyREST;

import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("/webfaculty")
public class WebFacultyResource {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTMLFacultyInfo() {
		HashMap <Integer, Faculty> facultyHashMap = new HashMap<>();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Faculty.in");
		Scanner inFile = new Scanner(inputStream);
		while(inFile.hasNext()) {
			int f_id = inFile.nextInt();
			facultyHashMap.put(f_id, new Faculty(f_id, inFile.next(), inFile.next(), inFile.next(), inFile.nextDouble(), inFile.nextDouble()));
		}
		inFile.close();
		String html = "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"UTF-8\" />\r\n"
				+ "        <title>Faculty</title>\r\n"
				+ "        <!--BoostTrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body onload=\"fetchIpInfo()\">\r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">Faculty ID</th>\r\n"
				+ "                    <th scope=\"col\">Faculty LName</th>\r\n"
				+ "                    <th scope=\"col\">Faculty FName</th>\r\n"
				+ "                    <th scope=\"col\">Faculty ZipCode</th>\r\n"
				+ "                    <th scope=\"col\">Faculty Salary</th>\r\n"
				+ "                    <th scope=\"col\">Faculty Bonus Rate</th>\r\n"
				+ "                    <th scope=\"col\">Faculty Total Bonus</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>";
		Iterator <Integer> iterator = facultyHashMap.keySet().iterator();
		int totalBonus = 0;
		while (iterator.hasNext()) {
			int facultyId = iterator.next();
			ZipCodeRequest zipCodeRequest = new ZipCodeRequest();
			html += "<tr>\r\n"
					+ "                    <th scope=\"row\">"+facultyHashMap.get(facultyId).getF_id()+"</th>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_Lname()+"</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_Fname()+"</td>\r\n"
					+ "                    <td>"+zipCodeRequest.getZipcode(facultyHashMap.get(facultyId).getF_zipcodeBirth())+"</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_Salary()+"$</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_BonusRate()+"%</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).doCalc_Bonus()+"$</td>\r\n"
					+ "                </tr>";
			totalBonus += facultyHashMap.get(facultyId).doCalc_Bonus();
		}
		html += "            </tbody>\r\n"
				+ "        </table>\r\n"
				+ "		   <h1>The Total Faculty Bonus is: "+totalBonus+"$</h1>"	
				+ "		   <Br>"
				+ "		   <h1>Faculty HashMap Info Sorted (Sorted by Value Bonus)</h1>"	
				+ "        \r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">Faculty ID</th>\r\n"
				+ "                    <th scope=\"col\">Faculty LName</th>\r\n"
				+ "                    <th scope=\"col\">Faculty FName</th>\r\n"
				+ "                    <th scope=\"col\">Faculty ZipCode</th>\r\n"
				+ "                    <th scope=\"col\">Faculty Salary</th>\r\n"
				+ "                    <th scope=\"col\">Faculty Bonus Rate</th>\r\n"
				+ "                    <th scope=\"col\">Faculty Total Bonus</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>";
		iterator = facultyHashMap.keySet().stream().sorted(Comparator.comparing(key -> facultyHashMap.get(key).doCalc_Bonus())).iterator();
		while (iterator.hasNext()) {
			int facultyId = iterator.next();
			html += "<tr>\r\n"
					+ "                    <th scope=\"row\">"+facultyHashMap.get(facultyId).getF_id()+"</th>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_Lname()+"</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_Fname()+"</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_zipcodeBirth()+"</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_Salary()+"$</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).getF_BonusRate()+"%</td>\r\n"
					+ "                    <td>"+facultyHashMap.get(facultyId).doCalc_Bonus()+"$</td>\r\n"
					+ "                </tr>";
		}
		html += "            </tbody>\r\n"
				+ "        </table>\r\n"
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
}
