package view.course;

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
import view.IListPanel;

public class ListCourses extends JPanel implements IListPanel<Course> {
	private CourseView courseView;
	
	public ListCourses(List<Course> courses, CourseView courseView) {
		super();
		this.courseView = courseView;
				
		JLabel title = new JLabel("Kurser");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel courseCodeLabel = new JLabel("Kurskod");
		courseCodeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel courseLabel = new JLabel("Kursnamn");
		courseLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(courseCodeLabel);
		headers.add(courseLabel);
		headers.add(new JLabel());
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,4));
		add(headers);
		
		for(Course course : courses) {
			CourseListRow courseRow = new CourseListRow(course, this);
			add(courseRow);
		}
		
		JButton createButton = new JButton("Lägg till kurs");
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
		courseView.show(id);		
	}

	@Override
	public void create() {
		courseView.create();
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort kursen?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			courseView.delete(id);
		}
	}
}
