/**
 * View för rader av studenter vid listning av studenter gjord av: Felix
 */

package view.student;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Student;

public class StudentListRow extends JPanel {
	private JPanel listStudents;
	private JLabel name;
	private JLabel email;
	private JLabel phoneNr;
	
	private JButton showButton = new JButton("Visa student");
	private JButton deleteButton = new JButton("Ta bort student");
	
	public StudentListRow(Student student, ListStudents listStudents) {
		super();
		this.listStudents = listStudents;
		
		name = new JLabel(student.getName());
		email = new JLabel(student.getEmail());
		phoneNr = new JLabel(student.getPhoneNr());
		
		setLayout(new GridLayout(0,5));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listStudents.show(student.getStudentId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listStudents.delete(student.getStudentId());
			}
		});
		
		add(name);
		add(email);
		add(phoneNr);
		add(showButton);
		add(deleteButton);
	}
}
