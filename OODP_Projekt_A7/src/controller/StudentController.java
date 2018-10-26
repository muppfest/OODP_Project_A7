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
		Student s = (Student) studentDao.getById(id);
		return s;
	}
	
	public List<Student> ListStudents() {
		List<Student> slist = studentDao.getAll();
		return slist;
	}
}
