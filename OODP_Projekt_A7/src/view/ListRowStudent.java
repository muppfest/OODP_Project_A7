/**
 * View för rader av studenter vid listning av studenter gjord av: Marcus
 */

package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.person.Student;

public class ListRowStudent extends JPanel {
	private JPanel panel;
	private JLabel id;
	private JLabel name;
	private JLabel email;
	private JLabel phoneNr;
	
	private JButton showButton = new JButton("Visa student");
	private JButton deleteButton = new JButton("Ta bort student");
	
	public ListRowStudent(Student student, ListStudentsPanel panel) {
		super();
		this.panel = panel;
		
		id = new JLabel();
		id.setVisible(false);
		name = new JLabel(student.getName());
		email = new JLabel(student.getEmail());
		phoneNr = new JLabel(student.getPhoneNr());
		
		setLayout(new GridLayout(0,5));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.show(student.getStudentId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.delete(student.getStudentId());
			}
		});
		
		add(name);
		add(email);
		add(phoneNr);
		add(showButton);
		add(deleteButton);
	}
}
