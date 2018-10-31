package model;

import java.sql.Date;

public class Moment {
	private int momentId;
	private int courseId;
	private String momentCode;
	private String type;
	private String description;
	private String grade;
	private Date date;
	private double credit;
	private String place;
	
	private Course course;
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getMomentId() {
		return momentId;
	}
	public void setMomentId(int momentId) {
		this.momentId = momentId;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}	
	public String getMomentCode() {
		return momentCode;
	}
	public void setMomentCode(String code) {
		this.momentCode = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public void printMoment() {
		System.out.printf("Momentid: %d%nMomentkod: %s%nTyp: %s%nPlats: %s%nDatum: %s%nBeskrivning: %s%nBetyg: %s%nAntal poäng: %f hp%n", getMomentId(), getMomentCode(), getType(), getPlace(), getDate().toString(), getDescription(), getGrade(), getCredit());
	}
	
}
