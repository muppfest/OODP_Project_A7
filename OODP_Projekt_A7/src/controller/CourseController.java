package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	private CourseDao courseDao;
	private StudentDao studentDao;
	private TeacherDao teacherDao;
	private MomentDao momentDao;
	
	public CourseController() {
		courseDao = new CourseDao();
		studentDao = new StudentDao();
		teacherDao = new TeacherDao();
		momentDao = new MomentDao();
	}
	
	public Course ShowCourse(int id) {
		Course c = courseDao.getById(id);
		c.setMoments(momentDao.getAll().stream().filter(f -> f.getCourseId() == id).collect(Collectors.toList()));
		
		List<Teacher> teachers = teacherDao.getAllTeachersFromCourse(id);
		
		for(int i = 0; i < teachers.size(); i++) {
			Teacher t = new Teacher();
			t = teacherDao.getById(teachers.get(i).getTeacherId());
			teachers.set(i, t);
		}
		
		c.setTeachers(teachers);
		
		return c;
	}
	
	public Teacher showTeacher(int teacherId) {
		Teacher t = teacherDao.getById(teacherId);
		List<Course> courses = teacherDao.getAllCoursesFromTeacher(teacherId);
		
		for(int i = 0; i < courses.size(); i++) {
			Course c = courseDao.getById(i);
			courses.set(i, c);
		}
		
		t.setCourses(courses);
		
		return t;
	}
	
	public Moment showMoment(int momentId) {
		Moment moment = momentDao.getById(momentId);
		moment.setCourse(courseDao.getById(moment.getCourseId()));
		
		return moment;
	}		
	
	public List<Course> listCourses() {
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
		if(deleteCourseMoments(id)) {
			if(courseDao.delete(id)) {
				return true;
			}
			return false;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean insertMoment(Moment moment) {
		if(momentDao.insert(moment)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean updateMoment(Moment moment) {
		if(momentDao.update(moment)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteMoment(int id) {
		if(momentDao.delete(id)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteCourseMoments(int courseId) {
		if(momentDao.deleteAllCourseMoments(courseId)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteCourseTeachers(int courseId, int teacherId) {
		if(teacherDao.deleteTeacherFromCourse(courseId, teacherId)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public String getCourseName(int id) {
		return courseDao.getById(id).getName();
	}
}
