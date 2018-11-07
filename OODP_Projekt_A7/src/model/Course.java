package model;

import java.sql.Date;
import java.util.List;

public class Course {
	private int courseId;
	private String courseCode;
	private String name;
	private Date startDate;
	private String description;
	private String finalGrade;
	private String courseScheduleURL;
	private String coursePlanURL;	
	
	private List<Student> students;
	private List<Teacher> teachers;
	private List<Moment> moments;
	private List<Program> programs;
	
	public List<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
	public String getCourseScheduleURL() {
		return courseScheduleURL;
	}
	public void setCourseScheduleURL(String courseScheduleURL) {
		this.courseScheduleURL = courseScheduleURL;
	}
	public String getCoursePlanURL() {
		return coursePlanURL;
	}
	public void setCoursePlanURL(String coursePlanURL) {
		this.coursePlanURL = coursePlanURL;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Moment> getMoments() {
		return moments;
	}
	public void setMoments(List<Moment> moments) {
		this.moments = moments;
	}
	public void printCourse() {
		System.out.printf("KursId: %s%nKurskod: %s%nNamn: %s%nBeskrivning: %s%nStartdatum: %s%nKursplan: %s%nKursschema: %s%nBetyg: %s%n", getCourseId(), getCourseCode(), getName(), getDescription(), getStartDate().toString(), getCoursePlanURL().toString(), getCourseScheduleURL().toString(), getFinalGrade());
	}
}