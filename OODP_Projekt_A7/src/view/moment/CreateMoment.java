package view.moment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Course;
import model.Moment;
import view.course.CourseView;

public class CreateMoment extends JPanel {
	private CourseView courseView;
	
	private int courseId;
	private String courseName;
	
	private JTextField momentCode;
	private JTextField momentType;
	private JTextField description;
	private JTextField grade;
	private JTextField credit;
	private JTextField place;
	
	private JButton saveButton = new JButton("Lägg till program");
	private JButton backButton = new JButton("Gå tillbaka");
	
	public CreateMoment(CourseView courseView, int courseId, String courseName) {
		this.courseView = courseView;
		this.courseId = courseId;
		this.courseName = courseName;
		
		JLabel title = new JLabel("Lägg till moment i " + courseName);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		momentCode = new JTextField();
		momentType = new JTextField();
		description = new JTextField();
		grade = new JTextField();
		credit = new JTextField();
		place = new JTextField();
		
		JLabel codeLabel = new JLabel("Programkod");
		JLabel typeLabel = new JLabel("Namn");;
		JLabel descriptionLabel = new JLabel("Beskrivning");
		JLabel gradeLabel = new JLabel("Betyg");
		JLabel creditLabel = new JLabel("Högskolepoäng");
		JLabel placeLabel = new JLabel("Plats");
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override		
		public void actionPerformed(ActionEvent e) {
			if(momentCode.getText().isEmpty() || momentType.getText().isEmpty()) {
				JOptionPane.showMessageDialog(courseView,
					    "Momentets typ och kod måste fyllas i.");
			} else {
				create();
			}				
	
			}});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.listMoments(courseId);
			}
		});
	
		add(codeLabel);
		add(momentCode);
		add(typeLabel);
		add(momentType);
		add(descriptionLabel);
		add(description);
		add(gradeLabel);
		add(grade);
		add(creditLabel);
		add(credit);
		add(placeLabel);
		add(place);
		add(saveButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
	}
	
	public void create() {
		Moment m = new Moment();
		m.setCourseId(courseId);
		m.setMomentCode(momentCode.getText());
		m.setType(momentType.getText());
		if(!credit.getText().isEmpty()) {
			m.setCredit(Double.parseDouble(credit.getText()));
		} 
		m.setGrade(grade.getText());
		m.setPlace(place.getText());
		
		courseView.insertMoment(m);
	}
}
