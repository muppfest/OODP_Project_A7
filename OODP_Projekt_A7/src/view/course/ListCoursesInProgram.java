package view.course;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import view.IListPanel;
import view.course.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Course;
import view.program.ProgramCourseRow;
import view.program.ProgramView;

public class ListCoursesInProgram extends JPanel implements IListPanel {
	private int programId;
	private ProgramView programView;
	
	public ListCoursesInProgram(List<Course> courses, ProgramView programView) {
		this.programView = programView;
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
			ProgramCourseRow courseRow = new ProgramCourseRow(course, this);
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
	
	public void createProgramCourse(int programId) {
		this.programId = programId;
		
	}
	
	public void delete(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort kursen?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			//programView.deleteCourse(courseId, programId);
		}
	}
	
	public void create() {
		programView.createCourse(programId);
	}

	@Override
	public void show(int id) {
		
	}

	@Override
	public void sort() {
		
	}
}
