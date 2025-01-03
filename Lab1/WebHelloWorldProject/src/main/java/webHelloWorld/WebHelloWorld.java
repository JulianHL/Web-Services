package webHelloWorld;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebHelloWorld
 */
@WebServlet("/WebHelloWorld")
public class WebHelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebHelloWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("University.in");
		Scanner inFile = new Scanner(inputStream);
		
		University [] universities = new University[2];
	
		ArrayList<University> universitiesList = new ArrayList<University>();
		HashMap<String, University> universitiesMap = new HashMap<String, University>();
		
		for(int i = 0; i < universities.length; i++) {
			
			String name = inFile.next()+" "+inFile.next();
			int yearOfEstablishment = inFile.nextInt();
			int numberOfPrograms = inFile.nextInt(); 

			universities[i] = new University(name, yearOfEstablishment, numberOfPrograms);
			universitiesList.add(universities[i]);
			universitiesMap.put(name, universities[i]);
		}
		
		inFile.close();
		
		response.setContentType("text/html");
		
		PrintStream out = new PrintStream(response.getOutputStream());
		
		out.print("<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"utf-8\" />\r\n"
				+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "        <title>Home</title>\r\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
				+ "\r\n"
				+ "        <!--Fonts-->\r\n"
				+ "        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\" />\r\n"
				+ "        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin />\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://fonts.googleapis.com/css2?family=Oswald:wght@200..700&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap\"\r\n"
				+ "            rel=\"stylesheet\" />\r\n"
				+ "\r\n"
				+ "        <!--BootsTrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "        <!--Style CSS-->\r\n"
				+ "        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"CSS/styles.css\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <p>Hello World, so cool to develop Web Services<p>"
				+ "        <br>\r\n"
				+ "        <h1>Vanier College</h1>\r\n");
		out.print("        <br>\r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">Pdr Price</th>\r\n"
				+ "                    <th scope=\"col\">Pdr Qty</th>\r\n"
				+ "                    <th scope=\"col\">University Number of Programs</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>"
				+ "            <tbody>\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>5.99</td>\r\n"
				+ "                    <td>6.0</td>\r\n"
				+ "                    <td>35.94</td>\r\n"
				+ "                </tr>\r\n"
				+ "            </tbody>\r\n"
				+ "        </table>\r\n"
				+ "        <br>\r\n");
		out.print("        <p>"+universities[0].getName()+"</p>\r\n"
				+ "        <p>"+universities[0].getYearOfEstablishment()+"</p>\r\n"
				+ "        <p>"+universities[0].getNumberOfPrograms()+"</p>\r\n"
				+ "        <br>\r\n"
				+ "        <p>"+universities[0]+"</p>\r\n"
				+ "        <p>"+universities[1]+"</p>\r\n"
				+ "        <br>\r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">University Name</th>\r\n"
				+ "                    <th scope=\"col\">University Year of Establishment</th>\r\n"
				+ "                    <th scope=\"col\">University Number of Programs</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>"
				+ "            <tbody>\r\n");
		universitiesList.forEach(university -> {
						out.print("<tr>\r\n"
				+ "                    <td>"+university.getName()+"</td>\r\n"
				+ "                    <td>"+university.getYearOfEstablishment()+"</td>\r\n"
				+ "                    <td>"+university.getNumberOfPrograms()+"</td>\r\n"
				+ "                </tr>");
		});
		
		out.print("        		</tbody>\r\n"
				+ "        	</table>\r\n"
				+ "        		<br>\r\n"
				+"        		<table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">University Name</th>\r\n"
				+ "                    <th scope=\"col\">University Year of Establishment</th>\r\n"
				+ "                    <th scope=\"col\">University Number of Programs</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>"
				+ "            <tbody>\r\n");
		
		universitiesMap.forEach((key, university) -> {
			out.print("<tr>\r\n"
				+ "                    <td>"+key+"</td>\r\n"
				+ "                    <td>"+university.getYearOfEstablishment()+"</td>\r\n"
				+ "                    <td>"+university.getNumberOfPrograms()+"</td>\r\n"
				+ "                </tr>");
		});
		
		out.print("        		</tbody>\r\n"
				+ "        	</table>\r\n"
				+ "        		<br>\r\n"
				+"        <script\r\n"
				+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n"
				+ "            crossorigin=\"anonymous\"></script>\r\n"
				+ "        <!--js-->\r\n"
				+ "        <script src=\"JavaScript/index.js\"></script>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
