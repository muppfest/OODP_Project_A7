/**
 * Delvy för att lista kurser inom ett specifikt program gjord av Marcus Vretling Pistelli
 */

package view.program;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Course;

public class ListProgramCoursesRow extends JPanel {
	private ListProgramCourses listProgramCourses;
	
	private JButton showButton = new JButton("Visa kurs");
	private JButton deleteButton = new JButton("Ta bort kursen från programmet");
	
	public ListProgramCoursesRow(ListProgramCourses listProgramCourses, Course course) {
		this.listProgramCourses = listProgramCourses;
		
		JLabel code = new JLabel(course.getCourseCode());
		JLabel name = new JLabel(course.getName());
		
		setLayout(new GridLayout(0,4));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listProgramCourses.show(course.getCourseId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listProgramCourses.deleteCourseFromProgram(course.getCourseId());
			}
		});
		
		add(code);
		add(name);
		add(showButton);
		add(deleteButton);
	}
}
