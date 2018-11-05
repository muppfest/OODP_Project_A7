/**
 * Vy för att lista kurser inom ett program gjord av Marcus Vretling Pistelli
 */

package view.program;

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
import model.Program;
import view.ComboBoxItem;
import view.IListPanel;

public class ListProgramCourses extends JPanel implements IListPanel<Course> {

	private ProgramView programView;
	private int programId;
	
	public ListProgramCourses(ProgramView programView, List<Course> courses, int programId) {
		this.programView = programView;
		this.programId = programId;
		
		JLabel title = new JLabel("Kurser inom " + programView.getProgramName(programId));
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel codeLabel = new JLabel("Kurskod");
		codeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(codeLabel);
		headers.add(nameLabel);
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,3));
		add(headers);
		
		JComboBox<ComboBoxItem> comboBox = new JComboBox();
		List<Course> coursesList = programView.getListOfCourses();
		
		for(int i = 0; i < courses.size(); i++) {
			for(int j = 0; j < coursesList.size(); j++) {
				if(courses.get(i).getCourseId() == coursesList.get(j).getCourseId()) {
					coursesList.remove(j);
				}
			}
		}
		
		for(Course course : coursesList) {
			ComboBoxItem item = new ComboBoxItem(course.getCourseId(), course.getName());
			comboBox.addItem(item);
		}
				
		for(Course course : courses) {
			ListProgramCoursesRow courseRow = new ListProgramCoursesRow(this, course);
			add(courseRow);
		}
		
		add(comboBox);
		JButton createButton = new JButton("Lägg till vald kurs");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
				insert(item);
			}
		});
				
		JButton backButton = new JButton("Gå tillbaka");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				programView.show(programId);
			}
		});
		
		add(createButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
	}
	
	public void insert(ComboBoxItem item) {
		programView.insertProgramCourse(item.getIndex(), programId);
	}
	
	@Override
	public void show(int id) {
		// TODO Auto-generated method stub
		
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
		
	}
	
	public void deleteCourseFromProgram(int courseId) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort kursen från programmet?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {		
			programView.deleteCourseFromProgram(courseId, programId);
		}
	}
}
