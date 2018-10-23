package model;

import java.util.List;

import model.person.Student;

public class Group {
	private int groupId;
	private String name;
	private String description;
	private List<Student> students;
	private List<Moment> moments;
	
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
	public List<Moment> getMoments() {
		return moments;
	}
	public void setMoments(List<Moment> moments) {
		this.moments = moments;
	}
	
	
}
