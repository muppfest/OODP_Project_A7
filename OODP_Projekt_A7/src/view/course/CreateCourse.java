/**
 * Vy för att skapa kurser gjord av Marcus Vretling Pistelli
 */

package view.course;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Course;
import model.person.Student;
import view.ICreatePanel;

public class CreateCourse extends JPanel implements ICreatePanel {
	private CourseView courseView;
	
	private JTextField courseCode;
	private JTextField courseName;
	private JTextField date;
	private JTextField coursePlanURL;
	private JTextField courseScheduleURL;
	private JTextField finalGrade;
	private JTextField description;
	
	private JButton saveButton = new JButton("Lägg till kurs");
	private JButton backButton = new JButton("Gå tillbaka");
	
	public CreateCourse(CourseView courseView) {
		this.courseView = courseView;
		
		JLabel title = new JLabel("Lägg till kurs");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel codeLabel = new JLabel("Kurskod");
		JLabel nameLabel = new JLabel("Kursnamn");
		JLabel dateLabel = new JLabel("Startdatum");
		JLabel scheduleLabel = new JLabel("Schema");
		JLabel planLabel = new JLabel("Kursplan");
		JLabel gradeLabel = new JLabel("Slutbetyg");
		JLabel descriptionLabel = new JLabel("Beskrivning");
		
		courseCode = new JTextField();
		courseName = new JTextField();
		date = new JTextField();
		coursePlanURL = new JTextField();
		courseScheduleURL = new JTextField();
		finalGrade = new JTextField();
		description = new JTextField();
				
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(courseName.getText().isEmpty() || courseCode.getText().isEmpty()){
					JOptionPane.showMessageDialog(courseView,
						    "Kursnamn och kurskod måste fyllas i");
				} else {
					create();
				}				
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.list();
			}
		});
		
		add(codeLabel);
		add(courseCode);
		add(nameLabel);
		add(courseName);
		add(dateLabel);
		add(date);
		add(planLabel);
		add(coursePlanURL);
		add(scheduleLabel);
		add(courseScheduleURL);
		add(gradeLabel);
		add(finalGrade);
		add(descriptionLabel);
		add(description);
		add(saveButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
	}
	
	public void create() {
		Course c = new Course();
		
		c.setCourseCode(courseCode.getText());
		c.setName(courseName.getText());
		
		if(!date.getText().isEmpty()) {
			c.setStartDate(Date.valueOf(date.getText()));
		}
		
		c.setCoursePlanURL(coursePlanURL.getText());
		c.setCourseScheduleURL(courseScheduleURL.getText());
		c.setDescription(description.getText());
		c.setFinalGrade(finalGrade.getText());
		
		courseView.insert(c);
	}
	
	public boolean IsValidDateFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		try {
			java.util.Date d = dateFormat.parse(date.getText());
			if(dateFormat.format(d).equals(date.getText())) {
				return true;
			}
		} catch (ParseException ex) {
			return false;
		}
		return false;			
	}
}
