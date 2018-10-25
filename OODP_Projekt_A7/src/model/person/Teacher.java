package model.person;

public class Teacher extends Person {
	private int teacherId;
	private String office;

	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public void printTeacher() {
		System.out.printf("LärarId: %d%nNamn: %s%nE-post: %s%nTelefonnummer: %s%nKontorsrum: %s%n", getTeacherId(), getName(), getEmail(), getPhoneNr(), getOffice());
	}
}
