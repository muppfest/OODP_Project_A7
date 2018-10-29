package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Course;

public class CourseListRow extends JPanel {
	private JPanel listCourses;
	private JLabel courseCode;
	private JLabel courseName;
	private JLabel date;
	
	private JButton showButton = new JButton("Visa kurs");
	private JButton deleteButton = new JButton("Ta bort kurs");
	
	public CourseListRow(Course course, ListCourses listCourses) {
		super();
		this.listCourses = listCourses;
		
		courseCode = new JLabel(course.getCourseCode());
		courseName = new JLabel(course.getName());
		date = new JLabel(course.getStartDate().toString());
		
		setLayout(new GridLayout(0,5));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listCourses.show(course.getCourseId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listCourses.delete(course.getCourseId());
			}
		});
		
		add(courseCode);
		add(courseName);
		add(date);
		add(showButton);
		add(deleteButton);
	}
}
