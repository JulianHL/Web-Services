package webHelloWorld;

public class University {

	private String name;
	private int yearOfEstablishment;
	private int numberOfPrograms;
	
	// constructor
	public University(String name, int yearOfEstablishment, int numberOfPrograms) {
		this.name = name;
		this.yearOfEstablishment = yearOfEstablishment;
		this.numberOfPrograms = numberOfPrograms;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	
	public int getYearOfEstablishment() {
		return yearOfEstablishment;
	}
	
	public int getNumberOfPrograms() {
		return numberOfPrograms;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYearOfEstablishment(int yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}
	
	public void setNumberOfPrograms(int numberOfPrograms) {
		this.numberOfPrograms = numberOfPrograms;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", yearOfEstablishment=" + yearOfEstablishment + ", numberOfPrograms="
				+ numberOfPrograms + "]";
	}
}
