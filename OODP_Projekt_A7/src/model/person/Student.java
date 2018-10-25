package model.person;

public class Student extends Person {
	private int studentId;
	private String city;
	private String address;
	private int programId;
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public void printStudent() {
		System.out.printf("StudentId: %d%nProgramId: %s%nNamn: %s%nE-post: %s%nTelefonnummer: %s%nAdress: %s%nOrt: %s",getStudentId(), getProgramId(), getName(), getEmail(), getPhoneNr(), getAddress(), getCity());
	}
}
