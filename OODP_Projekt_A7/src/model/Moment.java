package model;

import java.sql.Date;

public class Moment {
	private String code;
	private String type;
	private String description;
	private String grade;
	private Date date;
	private double credit;
	private String place;
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getLastRegisterDate() {
		return lastRegisterDate;
	}
	public void setLastRegisterDate(Date lastRegisterDate) {
		this.lastRegisterDate = lastRegisterDate;
	}
	private Date lastRegisterDate;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
	
}
