package webFacultyREST;


public class Faculty {
	
	private int f_id;
	private String f_Lname;
	private String f_Fname;
	private String f_zipcodeBirth;
	private double f_Salary;
	private double f_BonusRate;
	private double f_Bonus;
	private double f_Bonus_tax;

	
	public Faculty() {
		f_id = 0;
		f_Lname = "";
		f_Fname = "";
		f_zipcodeBirth = "";
		f_Salary = 0.0;
		f_BonusRate = 0.0;
		f_Bonus = doCalc_Bonus();

		
	}
	
	public Faculty(int f_id, String f_Lname, String f_Fname, String f_zipcodeBirth, double f_Salary, double f_BonusRate) {
		this.f_id = f_id;
		this.f_Lname = f_Lname;
		this.f_Fname = f_Fname;
		this.f_zipcodeBirth = f_zipcodeBirth;
		this.f_Salary = f_Salary;
		this.f_BonusRate = f_BonusRate;
		f_Bonus = doCalc_Bonus();
		
	}
	
	//Getters and Setters
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_Lname() {
		return f_Lname;
	}
	public void setF_Lname(String f_Lname) {
		this.f_Lname = f_Lname;
	}
	public String getF_Fname() {
		return f_Fname;
	}
	public void setF_Fname(String f_Fname) {
		this.f_Fname = f_Fname;
	}
	public String getF_zipcodeBirth() {
		return f_zipcodeBirth;
	}
	public void setF_zipcodeBirth(String f_zipcodeBirth) {
		this.f_zipcodeBirth = f_zipcodeBirth;
	}
	public double getF_Salary() {
		return f_Salary;
	}
	public void setF_Salary(double f_Salary) {
		this.f_Salary = f_Salary;
	}
	public double getF_BonusRate() {
		return f_BonusRate;
	}
	public void setF_BonusRate(double f_BonusRate) {
		this.f_BonusRate = f_BonusRate;
	}
	
	//Methods
	
	//toString
	@Override
	public String toString() {
		return "Faculty [f_id=" + f_id + ", f_Lname=" + f_Lname + ", f_Fname=" + f_Fname + ", f_zipcodeBirth=" + f_zipcodeBirth + ", f_Salary=" + f_Salary
				+ ", f_BonusRate=" + f_BonusRate + "%,\n Faculty Bonus=" + f_Bonus + "$, Faculty Tax Bonus=" + f_Bonus_tax + "]";
	}
	//doCalc_bonus calculates the bonus based on the salary and bonus rate
	public double doCalc_Bonus() {
		return (f_Salary * f_BonusRate)/100.00;
	}
	
	

}
