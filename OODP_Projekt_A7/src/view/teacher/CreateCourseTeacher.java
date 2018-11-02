package view.teacher;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Course;
import view.ComboBoxItem;
import view.course.CourseView;

public class CreateCourseTeacher extends JPanel {
	private CourseView courseView;
	private String courseName;
	
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField office;
	
	public CreateCourseTeacher(CourseView courseView, int courseId) {
		this.courseView = courseView;
		courseName = courseView.getCourseName(courseId);
		List<Course> courses = courseView.getListOfCourses();		
		JComboBox<ComboBoxItem> comboBox = new JComboBox();	
		
		for(Course course : courses) {
			ComboBoxItem item = new ComboBoxItem(course.getCourseId(), course.getName());
			comboBox.addItem(item);
		}
		
		add(comboBox);
	}
}
