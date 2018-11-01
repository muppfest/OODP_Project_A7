package view.teacher;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Course;
import model.person.Teacher;
import view.IListPanel;
import view.course.CourseView;
import view.teacher.TeacherListRow;

public class ListTeachers extends JPanel implements IListPanel {
	private CourseView courseView;
	private int courseId;
	private String courseName;
	
	public ListTeachers(CourseView courseView, Course course) {
		this.courseView = courseView;
		this.courseId = course.getCourseId();
		this.courseName = course.getName();
		
		JLabel title = new JLabel("Lärare inom " + courseName);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(nameLabel);
		headers.add(new JLabel());
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,3));
		add(headers);
				
		for(Teacher teacher : course.getTeachers()) {
			TeacherListRow teacherRow = new TeacherListRow(teacher, this);
			add(teacherRow);
		}
		
		JButton createButton = new JButton("Lägg till lärare");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		
		add(createButton);
		
		setLayout(new GridLayout(0,1));
	}

	@Override
	public void show(int id) {
		courseView.showTeacher(id);
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort läraren från kursen?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			courseView.deleteTeacher(courseId, id);
		}
	}
}
