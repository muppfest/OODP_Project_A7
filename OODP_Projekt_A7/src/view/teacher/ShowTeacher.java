package view.teacher;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.course.CourseView;
import view.moment.ListMoments;

public class ShowTeacher {
	private CourseView courseView;
	private ListMoments listMoments;
	
	private int id;
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField office;
	
	private JButton editButton = new JButton("Redigera");
	private JButton saveButton = new JButton("Spara ändringar");
	private JButton cancelButton = new JButton("Avbryt");
	
	private JLabel title = new JLabel("Lärare");
	
	public ShowTeacher() {
		
	}
}
