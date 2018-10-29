/**
 * View för listning av studenter gjord av: Marcus
 */

package view;

import java.awt.BorderLayout;
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

public class ListStudentsPanel extends JPanel implements IListPanel<Student> {
	private StudentTest frame;
	private List<ListRowStudent> studentRows = new ArrayList<ListRowStudent>();
	
	public ListStudentsPanel(List<Student> students, StudentTest frame) {
		super();
		this.frame = frame;
		
		JLabel title = new JLabel("Lista studenter");
		title.setFont(new Font("Arial", Font.BOLD, 18));
		add(title);
		
		JLabel nameLabel = new JLabel("Fullständigt namn");
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
			ListRowStudent studentRow = new ListRowStudent(student, this);
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
		frame.showStudent(id);
	}
	
	@Override
	public void create() {
		frame.createStudent();
		
	}

	public void delete(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort studenten?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			frame.deleteStudent(id);
		}
	}
	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
}
