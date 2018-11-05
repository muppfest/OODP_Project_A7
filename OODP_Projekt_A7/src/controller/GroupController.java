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
import model.person.Student;

public class GroupController {
	private IDao<Student> studentDao;
	private IDao<Group> groupDao;
	private IDao<Moment> momentDao;
	private IDao<Course> courseDao;
	
	public GroupController() {
		studentDao = new StudentDao();
		groupDao = new GroupDao();
		momentDao = new MomentDao();
		courseDao = new CourseDao();
	}
	
	public List<Group> listGroups() {
		List<Group> groups = groupDao.getAll();
		
		for(int i = 0; i < groups.size(); i++) {
			
		}
		
		return groups;
	}
	
	public Group ShowGroup(int id) {
		Group group = groupDao.getById(id);
		return group;
	}
	
	public boolean insertGroup(Group group) {
		if(groupDao.insert(group)) {
			return true;
		} else {
			System.out.println("Något gick fel");
			return false;
		}
	}
	
	public boolean deleteGroup(int id) {
		if(groupDao.delete(id)) {
			return true;
		} else {
			System.out.println("Något gick fel");
			return false;
		}
	}
	
	public boolean updateGroup(Group group) {
		if(groupDao.update(group)) {
			return true;
		} else {
			System.out.println("Något gick fel");
			return false;
		}
	}
}
