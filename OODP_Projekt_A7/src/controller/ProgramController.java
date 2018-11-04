package controller;

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
/**
 * Programkontroller gjord av Marcus Vretling Pistelli
 */

public class ProgramController {
	private ProgramDao programDao;
	private CourseDao courseDao;
		
	public ProgramController() {
		programDao = new ProgramDao();
		courseDao = new CourseDao();
	}
	
	public Program showProgram(int id) {
		Program p = programDao.getById(id);
		p.setCourses(courseDao.getAllCoursesFromProgram(id));
		
		return p;
	}
	
	public boolean insertCourseIntoProgram(int courseId, int programId) {
		if(courseDao.insertCourseIntoProgram(courseId, programId)) {
			return true; 
		} 		
		
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteCourseFromProgram(int courseId, int programId) {
		if(courseDao.deleteCoursesFromProgram(courseId, programId)) {
			return true;
		}
		
		System.out.println("Något gick fel");
		return false;
	}
	
	public List<Course> listCourses() {
		List<Course> courses = courseDao.getAll();
		return courses;
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
	
	public List<Course> listCoursesInProgram(int programId) {
		List<Course> courses = courseDao.getAllCoursesFromProgram(programId);
		
		return courses;
	}
}
