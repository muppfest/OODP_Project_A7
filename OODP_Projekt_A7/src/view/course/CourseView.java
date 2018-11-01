package view.course;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.CourseController;
import model.Course;
import model.Moment;
import model.person.Teacher;
import view.IView;
import view.View;
import view.moment.CreateMoment;
import view.moment.ListMoments;
import view.moment.ShowMoment;
import view.teacher.ListTeachers;

public class CourseView extends JPanel implements IView<Course> {
	private View frame;
	private CourseController controller;
	
	private ListCourses listCoursesPanel;
	private ShowCourse showCoursePanel;
	private CreateCourse createCoursePanel;
	private ListMoments listMomentsPanel;
	private CreateMoment createMomentPanel;
	private ShowMoment showMomentPanel;
	private ListTeachers listTeachersPanel;
		
	public CourseView(View frame) {
		this.frame = frame;
		controller = new CourseController();
		list();
	}
	
	public View getFrame() {
		return frame;
	}
	
	public List<Course> getListOfCourses() {
		return controller.listCourses();
	}
	
	public void createMoment(int courseId, String courseName) {
		createMomentPanel = new CreateMoment(this, courseId, courseName);
		removeAll();
		add(createMomentPanel);
		frame.refresh();
	}
	
	public void listTeachers(int courseId) {
		Course course = controller.ShowCourse(courseId);
		listTeachersPanel = new ListTeachers(this, course);
		removeAll();
		add(listTeachersPanel);
		frame.refresh();
	}
	
	public void showTeacher(int teacherId) {
		
	}
	
	public void updateMoment(Moment moment) {
		if(controller.updateMoment(moment)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursmomentet uppdaterades.");
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	public void insertMoment(Moment moment) {
		if(controller.insertMoment(moment)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursmomentet lades till.");
			listMoments(moment.getCourseId());
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}				
	}
	
	public void deleteMoment(int courseId, int momentId) {
		if(controller.deleteMoment(momentId)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursmomentet togs bort.");
			listMoments(courseId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	public void deleteTeacher(int courseId, int teacherId) {
		if(controller.deleteCourseTeachers(courseId, teacherId)) {
			JOptionPane.showMessageDialog(frame,
				    "Läraren togs bort från programmet.");
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}
	}

	public void showMoment(int momentId) {
		Moment m = controller.ShowMoment(momentId);
		showMomentPanel = new ShowMoment(this, m);
		removeAll();
		add(showMomentPanel);
		frame.refresh();
	}
	
	public void listMoments(int courseId) {
		Course c = controller.ShowCourse(courseId);
		listMomentsPanel = new ListMoments(this, c);
		removeAll();
		add(listMomentsPanel);
		frame.refresh();
	}
	
	@Override
	public void list() {
		List<Course> courses = controller.listCourses();
		listCoursesPanel = new ListCourses(courses, this);
		removeAll();
		add(listCoursesPanel);
		frame.refresh();
	}
	
	@Override
	public void create() {
		createCoursePanel = new CreateCourse(this);
		removeAll();
		add(createCoursePanel);
		frame.refresh();
	}

	@Override
	public void show(int id) {	
		Course course = controller.ShowCourse(id);
		showCoursePanel = new ShowCourse(course, this);
		removeAll();
		add(showCoursePanel);
		frame.refresh();
	}

	@Override
	public void insert(Course c) {
		if(controller.insertCourse(c)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursen lades till.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}

	@Override
	public void update(Course c) {
		if(controller.updateCourse(c)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursen uppdaterades.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}		

	@Override
	public void delete(int id) {
		if(controller.deleteCourse(id)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursen togs bort.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}
	}
}
