package model;

import java.util.List;

public class Teacher extends Person {
	private int teacherId;
	private String office;

	List<Course> courses;
	List<Program> programs;

	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
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
