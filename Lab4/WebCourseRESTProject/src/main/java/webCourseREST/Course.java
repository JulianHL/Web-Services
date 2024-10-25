package webCourseREST;


public class Course {

	private String course_no;
	private String course_name;
	private int max_enrl;
	
	public static int credits;
	
	
//	CONSTRUCTORS
	
	//default
	public Course() {
		course_no = "";
		course_name = "";
		max_enrl = 0;
		credits = 0;
	}
	
	//parameterized
	public Course(String course_no, String course_name, int credits, int max_enrl) {
		this.course_no = course_no;
		this.course_name = course_name;
		this.max_enrl = max_enrl;
		Course.credits = credits;
	}
	

//	SETTERS & GETTERS
	
	public void setCourse_no(String course_no) {
		this.course_no = course_no;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public void setMax_enrl(int max_enrl) {
		this.max_enrl = max_enrl;
	}
	
	public String getCourse_no() {
		return course_no;
	}
	public String getCourse_name() {
		return course_name;
	}
	public int getMax_enrl() {
		return max_enrl;
	}
	
	//Methods
	
	//toString
	@Override
	public String toString() {
		return "Course Code:" + course_no + ", Course Name: " + course_name + "Credits: " + credits + ", Max Enrolled: " + max_enrl+"\n\tTotal Fees: " + calculateTotalFees()+"$";
	}
	
	//Methods
	public double calculateTotalFees() {
		return 250*max_enrl;
	}
	
}
