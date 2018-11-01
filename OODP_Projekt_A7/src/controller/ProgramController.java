package controller;

import java.util.ArrayList;
import java.util.List;

import dao.CourseDao;
import dao.IDao;
import dao.ProgramDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Course;
import model.Program;
import model.person.Student;
import model.person.Teacher;

public class ProgramController {
	private ProgramDao programDao;
	private CourseDao courseDao;
	private TeacherDao teacherDao;
	private StudentDao studentDao;
	
	public ProgramController() {
		programDao = new ProgramDao();
		courseDao = new CourseDao();
		teacherDao = new TeacherDao();
		studentDao = new StudentDao();
	}
	
	public Program showProgram(int id) {
		Program p = programDao.getById(id);
		p.setCourses(programDao.selectAllCoursesFromProgram(id));
		return p;
	}
	
	public List<Program> listProgram() {
		List<Program> plist = programDao.getAll();
		return plist;
	}
	
	public boolean insertProgram(Program program) {
		if(programDao.insert(program)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean updateProgram(Program program) {
		if(programDao.update(program)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteProgram(int id) {
		if(programDao.delete(id)) {
			return true;
		} 
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean insertCourseToProgram (int courseId, int programId) {
		if(programDao.insertCourseToProgram(courseId, programId)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteCourseFromProgram (int courseId, int programId) {
		if(programDao.deleteCourseFromProgram(courseId, programId)) {
			return true;
		}
		return false;
	}
	
}
