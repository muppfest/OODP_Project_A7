package model;

import java.net.URL;
import java.sql.Date;
import java.util.List;

import model.person.Student;
import model.person.Teacher;

public class Course {
	private String courseCode;
	private String name;
	private Date startDate;
	private String description;
	private String finalGrade;
	private URL courseScheduleURL;
	private URL coursePlanURL;
	
	private List<Student> students;
	private List<Teacher> teachers;
	private List<Moment> moments;
	
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
	public URL getCourseScheduleURL() {
		return courseScheduleURL;
	}
	public void setCourseScheduleURL(URL courseScheduleURL) {
		this.courseScheduleURL = courseScheduleURL;
	}
	public URL getCoursePlanURL() {
		return coursePlanURL;
	}
	public void setCoursePlanURL(URL coursePlanURL) {
		this.coursePlanURL = coursePlanURL;
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
	
	
}