package webCourse;

public class Course {
	
	private String course_no;
	private String course_name;
	private int course_credits;
	private int max_enrl;

	
	// default constructor
	public Course() {
		course_no = "";
		course_name = "";
		course_credits = 0;
		max_enrl = 0;
	}
	
	// constructor
	public Course(String course_no, String course_name,int course_credits, int max_enrl) {
		super();
		this.course_no = course_no;
		this.course_name = course_name;
		this.course_credits = course_credits;
		this.max_enrl = max_enrl;
	}
	
	// getters and setters
	public String getCourse_no() {
		return course_no;
	}
	public void setCourse_no(String course_no) {
		this.course_no = course_no;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getMax_enrl() {
		return max_enrl;
	}
	public void setMax_enrl(int max_enrl) {
		this.max_enrl = max_enrl;
	}
	public int getCourse_credits() {
		return course_credits;
	}
	public void setCourse_credits(int course_credits) {
		this.course_credits = course_credits;
	}
	
	
	//Calculate total fees
	public double calculateTotalFees() {
		return max_enrl * 250;
	}
	
	  

}
