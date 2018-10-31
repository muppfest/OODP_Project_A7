/**
 * View för listning av studenter gjord av: Marcus
 */

package view.student;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.person.Student;
import view.IListPanel;

public class ListStudents extends JPanel implements IListPanel<Student> {
	private StudentView studentView;
	
	public ListStudents(List<Student> students, StudentView studentView) {
		super();
		this.studentView = studentView;
		
		JLabel title = new JLabel("Studenter");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel emailLabel = new JLabel("E-postadress");
		emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		phoneNrLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(nameLabel);
		headers.add(emailLabel);
		headers.add(phoneNrLabel);
		headers.add(new JLabel());
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,5));
		add(headers);
		
		for(Student student : students) {
			StudentListRow studentRow = new StudentListRow(student, this);
			add(studentRow);			
		}
		
		JButton createButton = new JButton("Lägg till student");
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
		studentView.show(id);
	}
	
	@Override
	public void create() {
		studentView.create();
		
	}

	public void delete(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort studenten?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			studentView.delete(id);
		}
	}
	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
}
