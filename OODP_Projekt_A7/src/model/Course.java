package model;

import java.net.URL;
import java.util.List;

import model.person.Student;
import model.person.Teacher;

public class Course {
	private String courseCode;
	private String name;
	private String description;
	private String finalGrade;
	private URL courseScheduleURL;
	private URL coursePlanURL;
	
	private List<Student> students;
	private List<Teacher> teachers;
	private List<Moment> moments;
}