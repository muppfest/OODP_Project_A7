/**
 * Vy för att visa kurser gjord av Marcus Vretling Pistelli
 */

package view.course;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
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
import view.IShowPanel;
import view.moment.ListMoments;

public class ShowCourse extends JPanel implements IShowPanel<Course> {
	private CourseView courseView;
	
	private int id;
	private JTextField courseCode;
	private JTextField courseName;
	private JTextField date;
	private JTextField coursePlanURL;
	private JTextField courseScheduleURL;
	private JTextField finalGrade;
	private JTextField description;
	
	private JButton editButton = new JButton("Redigera kurs");
	private JButton saveButton = new JButton("Spara ändringar");
	private JButton cancelButton = new JButton("Avbryt");
	private JButton showMomentsButton = new JButton("Visa kursmoment");
	private JButton backButton = new JButton("Gå tillbaka");
	private JButton showTeachersButton = new JButton("Visa kursens lärare");
	
	private JLabel title;
	
	public ShowCourse(Course course, CourseView courseView) {
		super();
		this.courseView = courseView;
		
		title = new JLabel(course.getName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		
		id = course.getCourseId();
		courseCode = new JTextField(course.getCourseCode());
		courseName = new JTextField(course.getName());
		if(course.getStartDate() != null) {
			date = new JTextField(course.getStartDate().toString());
		} else {
			date = new JTextField();
		}
		coursePlanURL = new JTextField(course.getCoursePlanURL());
		courseScheduleURL = new JTextField(course.getCourseScheduleURL());
		finalGrade = new JTextField(course.getFinalGrade());
		description = new JTextField(course.getDescription());
		
		coursePlanURL.setForeground(Color.BLUE);
		courseScheduleURL.setForeground(Color.BLUE);
		
		courseCode.setEditable(false);
		courseName.setEditable(false);
		date.setEditable(false);
		coursePlanURL.setEditable(false);
		courseScheduleURL.setEditable(false);
		finalGrade.setEditable(false);
		description.setEditable(false);
			
		JLabel codeLabel = new JLabel("Kurskod");
		JLabel nameLabel = new JLabel("Kursnamn");
		JLabel dateLabel = new JLabel("Startdatum");
		JLabel scheduleLabel = new JLabel("Schema");
		JLabel planLabel = new JLabel("Kursplan");
		JLabel gradeLabel = new JLabel("Slutbetyg");
		JLabel descriptionLabel = new JLabel("Beskrivning");
		
		add(title);
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
				
		setLayout(new GridLayout(0,1));		
		
		if(!coursePlanURL.getText().isEmpty()) {
		coursePlanURL.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(!coursePlanURL.isEditable()) {
					try {
						if(coursePlanURL.getText().startsWith("http://")) {
							Desktop.getDesktop().browse(new URL(course.getCoursePlanURL()).toURI());
						} else {
							Desktop.getDesktop().browse(new URL("http://" + course.getCoursePlanURL()).toURI());
						}
					} catch (IOException | URISyntaxException exception) {
						System.out.println(exception);
					}
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!coursePlanURL.isEditable()) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		}
		
		if(!courseScheduleURL.getText().isEmpty()) {
		courseScheduleURL.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(!courseScheduleURL.isEditable()) {
					try {
						if(courseScheduleURL.getText().startsWith("http://")) {
							Desktop.getDesktop().browse(new URL(course.getCourseScheduleURL()).toURI());
						} else {
							Desktop.getDesktop().browse(new URL("http://" + course.getCourseScheduleURL()).toURI());
						}
					} catch (IOException | URISyntaxException exception) {
						System.out.println(exception);
					}
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!courseScheduleURL.isEditable()) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		}
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!date.getText().isEmpty()) {
					if(IsValidDateFormat()) {
						save();
					} else {
						JOptionPane.showMessageDialog(courseView, "Datumet måste vara i följande format: åååå-mm-dd");
					}
				} else {
					save();
				}
			}
		});
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				edit();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.list();				
			}
		});
		
		showMomentsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.listMoments(course.getCourseId());
			}
		});
		
		showTeachersButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.listTeachers(id);
			}
		});
		
		add(editButton);
		add(saveButton);
		add(cancelButton);
		add(showMomentsButton);
		add(showTeachersButton);
		add(backButton);
		
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
	}
	
	@Override
	public void edit() {
		editButton.setVisible(false);
		saveButton.setVisible(true);
		cancelButton.setVisible(true);
		enableFields();
		refresh();
	}

	@Override
	public void save() {
		Course c = new Course();
		c.setCourseId(id);
		c.setCourseCode(courseCode.getText());
		c.setName(courseName.getText());
		if(!date.getText().isEmpty()) {
			c.setStartDate(Date.valueOf(date.getText()));
		}
		c.setCoursePlanURL(coursePlanURL.getText());
		c.setCourseScheduleURL(courseScheduleURL.getText());
		c.setDescription(description.getText());
		c.setFinalGrade(finalGrade.getText());
		
		editButton.setEnabled(true);
		saveButton.setEnabled(false);
		cancelButton.setEnabled(false);
		disableFields();
		
		courseView.update(c);
	}

	@Override
	public void enableFields() {
		courseCode.setEditable(true);
		courseName.setEditable(true);
		date.setEditable(true);
		coursePlanURL.setEditable(true);
		courseScheduleURL.setEditable(true);
		finalGrade.setEditable(true);
		description.setEditable(true);
	}

	@Override
	public void disableFields() {
		courseCode.setEditable(false);
		courseName.setEditable(false);
		date.setEditable(false);
		coursePlanURL.setEditable(false);
		courseScheduleURL.setEditable(false);
		finalGrade.setEditable(false);
		description.setEditable(false);		
	}

	@Override
	public void cancel() {
		saveButton.setVisible(false);;
		cancelButton.setVisible(false);;
		editButton.setVisible(true);;
		disableFields();
		refresh();		
	}

	@Override
	public void refresh() {
		revalidate();
		repaint();		
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
