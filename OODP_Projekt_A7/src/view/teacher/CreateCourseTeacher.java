package view.teacher;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Course;
import model.person.Teacher;
import view.ComboBoxItem;
import view.course.CourseView;

public class CreateCourseTeacher extends JPanel {
	private CourseView courseView;
	private String courseName;
	
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField office;
	
	private JButton createButton = new JButton("L�gg till ny l�rare");
	private JButton backButton = new JButton("G� tillbaka");
	
	private int courseId;
	
	public CreateCourseTeacher(CourseView courseView, int courseId) {
		this.courseView = courseView;
		this.courseId = courseId;
		courseName = courseView.getCourseName(courseId);
		
		name = new JTextField();
		email = new JTextField();
		phoneNr = new JTextField();
		office = new JTextField();
	
		JLabel nameLabel = new JLabel("Namn");
		JLabel emailLabel = new JLabel("E-postadress");
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		JLabel officeLabel = new JLabel("Kontorsrum");
		
		add(nameLabel);
		add(name);
		add(emailLabel);
		add(email);
		add(phoneNrLabel);
		add(phoneNr);
		add(officeLabel);
		add(office);
				
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Teacher teacher = new Teacher();
				teacher.setName(name.getText());
				teacher.setEmail(email.getText());
				teacher.setPhoneNr(phoneNr.getText());
				teacher.setOffice(office.getText());
				
				courseView.insertNewCourseTeacher(teacher, courseId);
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.listTeachers(courseId);				
			}
		});
		
		add(createButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
	}
}
