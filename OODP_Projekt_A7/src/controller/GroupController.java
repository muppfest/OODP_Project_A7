/**
 * controller för grupper gjord av Marcus
 */


package controller;

import java.util.List;

import dao.CourseDao;
import dao.GroupDao;
import dao.IDao;
import dao.MomentDao;
import dao.StudentDao;
import model.Course;
import model.Group;
import model.Moment;
import model.Student;

public class GroupController {
	private StudentDao studentDao;
	private GroupDao groupDao;
	private MomentDao momentDao;
	private CourseDao courseDao;
	
	public GroupController() {
		studentDao = new StudentDao();
		groupDao = new GroupDao();
		momentDao = new MomentDao();
		courseDao = new CourseDao();
	}
	
	public List<Group> listGroups() {
		List<Group> groups = groupDao.getAll();
		
		for(int i = 0; i < groups.size(); i++) {
			groups.get(i).setMoment(momentDao.getById(groups.get(i).getMomentId()));
			groups.get(i).getMoment().setCourse(courseDao.getById(groups.get(i).getMoment().getCourseId()));
		}
		
		return groups;
	}
	
	public Group ShowGroup(int id) {
		Group group = groupDao.getById(id);
		return group;
	}
	
	public Student ShowStudent(int studentId) {
		Student s = studentDao.getById(studentId);
		return s;
	}
	
	public boolean insertGroup(Group group) {
		if(groupDao.insert(group)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteGroup(int id) {
		if(studentDao.deleteAllStudentsFromGroup(id)) {
			if(groupDao.delete(id)) {
				return true;
			}
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean updateGroup(Group group) {
		if(groupDao.update(group)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public List<Student> listStudents(int groupId) {
		List<Student> students = studentDao.getAllStudentsFromGroup(groupId);
		return students;
	}
	
	public boolean insertNewStudent(Student s, int groupId) {
		if(studentDao.insert(s)) {
			if(studentDao.insertStudentIntoGroup(studentDao.getLastInsertedId(), groupId)) {
				return true;
			}
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean updateStudent(Student student) {
		if(studentDao.update(student)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean insertStudent(int studentId, int groupId) {
		if(studentDao.insertStudentIntoGroup(studentId, groupId)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteStudent(int studentId) {
		if(studentDao.deleteStudentFromAllGroups(studentId)) {
			if(studentDao.delete(studentId)) {
				return true;
			}
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public boolean deleteStudentFromGroup(int studentId, int groupId) {
		if(studentDao.deleteStudentFromGroup(groupId, studentId)) {
			return true;
		}
		System.out.println("Något gick fel");
		return false;
	}
	
	public List<Moment> getAllMoments() {
		List<Moment> moments = momentDao.getAll();
		
		return moments;
	}
	
	public List<Student> getAllStudents() {
		List<Student> students = studentDao.getAll();
		return students;
	}
		
	public String getGroupName(int groupId) {
		Group g = groupDao.getById(groupId);
		return g.getName();
	}
	
	public String getCourseNameFromMoment(int momentId) {
		int courseId = momentDao.getById(momentId).getCourseId();
		return courseDao.getById(courseId).getName();
	}
}
