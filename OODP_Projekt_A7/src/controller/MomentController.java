package controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import dao.CourseDao;
import dao.IDao;
import dao.MomentDao;
import model.Course;
import model.Moment;

public class MomentController {
	private IDao<Moment> momentDao;
	private IDao<Course> courseDao;
	
	public MomentController() {
		momentDao = new MomentDao();
		courseDao = new CourseDao();
	}
	
	public List<Moment> listMoments() {
		List<Moment> moments = momentDao.getAll();
				
		return moments;
	}
	
	public Moment showMoment(int id) {
		Moment moment = momentDao.getById(id);
				
		return moment;
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
}
