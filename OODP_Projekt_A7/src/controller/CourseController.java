package controller;

import java.util.List;

import dao.CourseDao;
import dao.IDao;
import dao.MomentDao;
import dao.ProgramDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Course;
import model.Moment;
import model.person.Student;
import model.person.Teacher;

public class CourseController {
	private IDao<Course> courseDao;
	private IDao<Student> studentDao;
	private IDao<Teacher> teacherDao;
	private IDao<Moment> momentDao;
	
	public CourseController() {
		courseDao = new CourseDao();
		studentDao = new StudentDao();
		teacherDao = new TeacherDao();
		momentDao = new MomentDao();
	}
	
	public Course ShowCourse(int id) {
		Course c = courseDao.getById(id);
		return c;
	}
	
	public List<Course> ListCourses() {
		List<Course> clist = courseDao.getAll();
		return clist;
	}
	
	public boolean updateCourse(Course course) {
		if(courseDao.update(course)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean insertCourse(Course course) {
		if(courseDao.insert(course)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteCourse(int id) {
		if(courseDao.delete(id)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
}
