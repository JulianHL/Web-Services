package webCourseREST;

import java.io.InputStream;
import java.util.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;



@Path("WebCourse")
public class webCourseResource {

	private ArrayList<Course> courseList;
	
	public void fillingList() {
		courseList = new ArrayList<>();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Course.in");
		Scanner inFile = new Scanner(inputStream);
		
		
		while(inFile.hasNext()){
			String [] courseInfo = inFile.nextLine().split("\t");
			courseList.add(new Course(courseInfo[0], courseInfo[1], Integer.parseInt(courseInfo[2]), Integer.parseInt(courseInfo[3])));
		}
		inFile.close();	
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTMLCourseInfo(){
		fillingList();
		String html = "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"UTF-8\" />\r\n"
				+ "        <title>Cours</title>\r\n"
				+ "        <!--BoostTrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">Course Number</th>\r\n"
				+ "                    <th scope=\"col\">Course Name</th>\r\n"
				+ "                    <th scope=\"col\">Max Enrolment</th>\r\n"
				+ "                    <th scope=\"col\">Credits</th>\r\n"
				+ "                    <th scope=\"col\">Total Course Fees</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>";
		double totalFees = 0;
		for(Course course : courseList) {
			html += "                <tr>\r\n"
					+ "                    <th scope=\"row\">"+course.getCourse_no()+"</th>\r\n"
					+ "                    <td>"+course.getCourse_name()+"</td>\r\n"
					+ "                    <td>"+course.getMax_enrl()+"</td>\r\n"
					+ "                    <td>"+Course.credits+"</td>\r\n"
					+ "                    <td>"+course.calculateTotalFees()+"$</td>\r\n"
					+ "                </tr>";
			totalFees += course.calculateTotalFees();
		}
		html += "            </tbody>\r\n"
				+ "        </table>"
				+ "        <h1>The Total of Course Fees is: "+totalFees+"$</h1>\r\n"
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
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String displayTextCourseInfo(){
		
		fillingList();
		String result = "";
		double totalFees = 0;
		for(Course course : courseList) {
			
			result+= course + "\n";
			totalFees += course.calculateTotalFees();
		}
		
		result += "\nThe Total of Course Fees is: " + totalFees + "$";
		return result;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchCourse/{course_no}")
	public Course searchJSONCourseInfo( @PathParam("course_no") String course_no) {
		fillingList();
		Course result = null;
		
		if(courseList != null && !courseList.isEmpty()) {
			for(Course course : courseList) {
				if (course.getCourse_no().equals(course_no)) {
					result = course;
					return result;
				}
			}
			
		}
		return result;
	}
}
