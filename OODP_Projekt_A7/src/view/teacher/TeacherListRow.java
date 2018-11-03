package view.teacher;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Course;
import model.person.Teacher;
import view.course.ListCourses;

public class TeacherListRow extends JPanel {
	private JPanel listTeachers;
	private JLabel name;
	
	private JButton showButton = new JButton("Visa information");
	private JButton deleteButton = new JButton("Ta bort lärare från kurs");
	
	public TeacherListRow(Teacher teacher, ListTeachers listTeachers) {
		super();
		this.listTeachers = listTeachers;
		
		name = new JLabel(teacher.getName());
				
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listTeachers.show(teacher.getTeacherId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listTeachers.deleteFromCourse(teacher.getTeacherId());
			}
		});
		
		add(name);
		add(showButton);
		add(deleteButton);
		
		setLayout(new GridLayout(0,3));
	}
}
