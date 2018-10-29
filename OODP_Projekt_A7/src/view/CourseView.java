package view;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.CourseController;
import model.Course;

public class CourseView extends JPanel implements IView<Course> {
	private View frame;
	private CourseController controller;
	
	private ListCourses listCoursesPanel;
	private ShowCourse showCoursePanel;
	private CreateCourse createCoursePanel;
	
	public CourseView(View frame) {
		this.frame = frame;
		controller = new CourseController();
		list();
	}
	
	@Override
	public void list() {
		List<Course> courses = controller.ListCourses();
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
