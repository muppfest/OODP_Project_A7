package view.teacher;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Course;
import model.person.Teacher;
import view.ComboBoxItem;
import view.IListPanel;
import view.course.CourseView;
import view.teacher.TeacherListRow;

public class ListTeachers extends JPanel implements IListPanel {
	private CourseView courseView;
	private int courseId;
	private String courseName;
	private JComboBox<ComboBoxItem> comboBox = new JComboBox();
	
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
		
		JComboBox<ComboBoxItem> comboBox = new JComboBox();	
		List<Teacher> teachers = courseView.getListOfTeachers();
		List<Teacher> courseTeachers = course.getTeachers();
		
		for(int i = 0; i < courseTeachers.size(); i++) {
			for(int j = 0; j < teachers.size(); j++) {
				if(courseTeachers.get(i).getTeacherId() == teachers.get(j).getTeacherId()) {
					teachers.remove(j);
				}
			}
		}
		
		
		for(Teacher teacher : courseTeachers) {
			TeacherListRow teacherRow = new TeacherListRow(teacher, this);
			add(teacherRow);
		}

		for(Teacher teacher : teachers) {
			ComboBoxItem item = new ComboBoxItem(teacher.getTeacherId(), teacher.getName());
			comboBox.addItem(item);
		}
		
		add(comboBox);
		
		JButton createButton = new JButton("Lägg till befintlig lärare");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insert((ComboBoxItem) comboBox.getSelectedItem());
			}
		});
		
		if(teachers.size() == 0) {
			createButton.setEnabled(false);
		} else {
			createButton.setEnabled(true);
		}
		
		JButton createNewButton = new JButton("Lägg till ny lärare");
		createNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		
		JButton backButton = new JButton("Gå tillbaka");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.show(courseId);
			}
		});
		
		JButton deleteButton = new JButton("Ta bort vald lärare från systemet");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
				delete(item.getIndex());
			}
		});
		
		add(createButton);
		add(deleteButton);
		add(createNewButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
	}

	public void insert(ComboBoxItem item) {
		courseView.insertCourseTeacher(courseId, item.getIndex());
	}
	
	@Override
	public void show(int id) {
		courseView.showTeacher(id, courseId);
		
	}

	@Override
	public void create() {
		courseView.createTeacher(courseId);
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort läraren från alla kurser", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			courseView.deleteTeacher(id);
			courseView.listTeachers(courseId);
		}
	}
	
	public void deleteFromCourse(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort läraren från kursen?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			courseView.deleteTeacherFromCourse(courseId, id);
			courseView.listTeachers(courseId);
		}
	}
}
