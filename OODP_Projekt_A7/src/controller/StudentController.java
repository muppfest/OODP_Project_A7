package controller;

import java.util.List;

import dao.IDao;
import dao.StudentDao;
import model.person.Student;

public class StudentController {
	private IDao studentDao;
	
	public StudentController() {
		studentDao = new StudentDao();
	}
	
	public Student ShowStudent(int id) {
		return null;
	}
	
	public List<Student> ListStudents() {
		return null;
	}
}
