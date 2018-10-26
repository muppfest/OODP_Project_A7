package controller;

import java.util.List;

import dao.IDao;
import dao.ProgramDao;
import dao.StudentDao;
import model.Program;
import model.person.Student;

public class StudentController {
	private IDao<Student> studentDao;
	private IDao<Program> programDao;
	
	public StudentController() {
		studentDao = new StudentDao();
		programDao = new ProgramDao();
	}
	
	public Student ShowStudent(int id) {
		Student s = studentDao.getById(id);
		s.setProgram(programDao.getById(s.getProgramId()));
		return s;
	}
	
	public List<Student> ListStudents() {
		List<Student> slist = studentDao.getAll();
		return slist;
	}
	
	public boolean updateStudent(Student student) {	
		if(studentDao.update(student)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
}
