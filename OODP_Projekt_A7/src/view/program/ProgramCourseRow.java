package view.program;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Course;
import view.course.ListCourses;
import view.course.ListCoursesInProgram;

public class ProgramCourseRow extends JPanel {
	private JPanel listCoursesInProgram;
	private JLabel courseCode;
	private JLabel courseName;
	
	private JButton showButton = new JButton("Visa kurs");
	private JButton deleteButton = new JButton("Ta bort kurs");
	
	public ProgramCourseRow(Course course, ListCoursesInProgram listCoursesInProgram) {
		super();
		this.listCoursesInProgram = listCoursesInProgram;
		
		courseCode = new JLabel(course.getCourseCode());
		courseName = new JLabel(course.getName());
		
		setLayout(new GridLayout(0,4));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listCoursesInProgram.show(course.getCourseId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listCoursesInProgram.delete(course.getCourseId());
			}
		});
		
		add(courseCode);
		add(courseName);
		add(showButton);
		add(deleteButton);
	}
}
