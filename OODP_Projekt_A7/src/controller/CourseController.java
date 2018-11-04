/**
 * Kurskontroller gjord av Marcus Vretling Pistelli
 */

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
		c.setTeachers(teacherDao.getAllTeachersFromCourse(id));
		
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
	
	public boolean updateTeacher(Teacher teacher) {
		if(teacherDao.update(teacher)) {
			return true;
		} else {
			System.out.println("Någit gick fel");
			return false;
		}
	}
	
	public boolean deleteTeacher(int teacherId) {
		if(teacherDao.deleteAllCoursesFromTeacher(teacherId)) {
			if(teacherDao.delete(teacherId)) {
				return true;
			}
		} 
		
		System.out.println("Något gick fel");
		return false;
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
			if(deleteAllTeachersFromCourse(id)) {
				if(courseDao.delete(id)) {
					return true;
				}
				return false;
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
	
	public boolean deleteTeacherFromCourse(int courseId, int teacherId) {
		if(teacherDao.deleteTeacherFromCourse(courseId, teacherId)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteAllTeachersFromCourse(int courseId) {
		if(teacherDao.deleteAllTeachersFromCourse(courseId)) {
			return true;
		} else {
			System.out.println("Något gick fel");
			return false;
		}
	}
	
	public boolean insertTeacherToCourse(int courseId, int teacherId) {
		if(teacherDao.insertTeacherToCourse(courseId, teacherId)) {
			return true;
		} else {
			System.out.println("Något gick fel");
			return false;
		}
	}
	
	public boolean teacherAlreadyExistInCourse(int courseId, int teacherId) {
		if(teacherDao.teacherAlreadyExistInCourse(courseId, teacherId)) {
			return false;
		} 
		return true;
	}
	
	public boolean insertNewTeacherIntoCourse(Teacher teacher, int courseId) {
		if(teacherDao.insert(teacher)) {
			if(insertTeacherToCourse(courseId, teacherDao.getLastInsertTeacherId())) {
				return true;
			}
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public String getCourseName(int id) {
		return courseDao.getById(id).getName();
	}
	
	public List<Teacher> listTeachers() {
		return teacherDao.getAll();
	}
}
