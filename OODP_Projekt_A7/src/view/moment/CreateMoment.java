/**
 * Vy för att skapa kursmoment gjord av Marcus Vretling Pistelli
 */

package view.moment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private JTextField date;
	
	private JButton saveButton = new JButton("Lägg till kursmoment");
	private JButton backButton = new JButton("Gå tillbaka");
	
	public CreateMoment(CourseView courseView, int courseId, String courseName) {
		this.courseView = courseView;
		this.courseId = courseId;
		this.courseName = courseName;
		
		JLabel title = new JLabel("Lägg till kursmoment i " + courseName);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		momentCode = new JTextField();
		momentType = new JTextField();
		description = new JTextField();
		grade = new JTextField();
		credit = new JTextField();
		place = new JTextField();
		date = new JTextField();
		
		JLabel codeLabel = new JLabel("Kursmomentskod");
		codeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel typeLabel = new JLabel("Typ");
		typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel descriptionLabel = new JLabel("Beskrivning");
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel gradeLabel = new JLabel("Betyg");
		gradeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel creditLabel = new JLabel("Högskolepoäng");
		creditLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel placeLabel = new JLabel("Plats");
		placeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel dateLabel = new JLabel("Slutdatum");
		dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override		
		public void actionPerformed(ActionEvent e) {
			if(momentCode.getText().isEmpty() || momentType.getText().isEmpty()) {
				JOptionPane.showMessageDialog(courseView,
					    "Momentets typ och kod måste fyllas i.");
			} else {
				if(IsValidDateFormat(date.getText())) {
					create();
				} else {
				JOptionPane.showMessageDialog(courseView,
						"Datumet måste vara i följande format: åååå-mm-dd");
				}
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
		add(dateLabel);
		add(date);
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
		m.setDate(Date.valueOf(date.getText()));
		m.setGrade(grade.getText());
		m.setPlace(place.getText());
		
		courseView.insertMoment(m);
	}
	
	public boolean IsValidDateFormat(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		try {
			java.util.Date d = dateFormat.parse(date);
			if(dateFormat.format(d).equals(date)) {
				return true;
			}
		} catch (ParseException ex) {
			return false;
		}
		return false;			
	}
}
