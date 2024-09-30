package webCourse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class WebCourseServerley
 */
@WebServlet("/WebCourseServerley")
public class WebCourseServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebCourseServerlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Course.in");
		Scanner inFile = new Scanner(inputStream);
		
		Course [] courses = new Course[7];
	

		
		for(int i = 0; i < courses.length; i++) {
			
			String [] corseInfo = inFile.nextLine().split("\t");
			
			String number = corseInfo[0];
			String name = corseInfo[1];
			int credits = Integer.parseInt(corseInfo[2]);
			int maxEnrollment = Integer.parseInt(corseInfo[3]);

			courses[i] = new Course(number, name, credits, maxEnrollment);
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
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">Course Number</th>\r\n"
				+ "                    <th scope=\"col\">Course Name</th>\r\n"
				+ "                    <th scope=\"col\">Max Enrollment</th>\r\n"
				+ "                    <th scope=\"col\">Credits</th>\r\n"
				+ "                    <th scope=\"col\">Total Course Fees</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>"
				+ "            <tbody>\r\n");
		double feesTotal = 0;
		for(Course course : courses) {
						out.print("<tr>\r\n"
				+ "                    <td>"+course.getCourse_no()+"</td>\r\n"
				+ "                    <td>"+course.getCourse_name()+"</td>\r\n"
				+ "                    <td>"+course.getMax_enrl()+"</td>\r\n"
				+ "                    <td>"+course.getCourse_credits()+"</td>\r\n"
				+ "                    <td>"+course.calculateTotalFees()+"$</td>\r\n"
				+ "                </tr>");
				feesTotal += course.calculateTotalFees();
		}
		out.print("        		</tbody>\r\n"
				+ "        	</table>\r\n"
				+ "        		<br>\r\n"
				+ "        		<h1>The Total of Course Fees is: "+feesTotal+"$<h1>\r\n"
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