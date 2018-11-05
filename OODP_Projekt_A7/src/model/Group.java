package model;

import java.util.List;

import model.person.Student;

public class Group {
	private int groupId;
	private String name;
	private String description;
	private int momentId;
	private List<Student> students;
	
	private Moment moment;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMomentId() {
		return momentId;
	}
	public void setMomentId(int momentId) {
		this.momentId = momentId;
	}
	public Moment getMoment() {
		return moment;
	}
	public void setMoment(Moment moment) {
		this.moment = moment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void printGroup() {
		System.out.printf("Gruppid: %d%nNamn: %s%nBeskrivning: %s%n", getGroupId(), getName(), getDescription());
	}
}
