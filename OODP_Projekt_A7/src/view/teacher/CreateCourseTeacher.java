/**
 * Vy för att skapa lärare gjord av Marcus Vretling Pistelli
 */

package view.teacher;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Course;
import model.Teacher;
import view.ComboBoxItem;
import view.course.CourseView;

public class CreateCourseTeacher extends JPanel {
	private CourseView courseView;
	private String courseName;
	
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField office;
	
	private JButton createButton = new JButton("Lägg till ny lärare");
	private JButton backButton = new JButton("Gå tillbaka");
	
	private JLabel title;
	
	private int courseId;
	
	public CreateCourseTeacher(CourseView courseView, int courseId) {
		this.courseView = courseView;
		this.courseId = courseId;
		courseName = courseView.getCourseName(courseId);
		
		title = new JLabel("Lägg till lärare i " + courseView.getCourseName(courseId));
		title.setFont(new Font("Arial", Font.BOLD, 20));
		
		name = new JTextField();
		email = new JTextField();
		phoneNr = new JTextField();
		office = new JTextField();
	
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel emailLabel = new JLabel("E-postadress");
		emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		phoneNrLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel officeLabel = new JLabel("Kontorsrum");
		officeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		add(title);
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
				
				if(name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(courseView, "Lärarens namn måste fyllas i");
				} else {
				
				Teacher teacher = new Teacher();
				teacher.setName(name.getText());
				teacher.setEmail(email.getText());
				teacher.setPhoneNr(phoneNr.getText());
				teacher.setOffice(office.getText());
				
				courseView.insertNewCourseTeacher(teacher, courseId);
				}
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
