/**
 * View för listning av studenter som implementerar IListPAnel. 
 * Gjord av Marcus 
 * */

package view.student;
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

import model.Student;
import view.ComboBoxItem;
import view.IListPanel;
import view.group.GroupView;

public class ListStudents extends JPanel implements IListPanel<Student> {
	private GroupView groupView;
	private int groupId;
	private int comboBoxStudentId;
	
	public ListStudents(GroupView groupView, List<Student> students, int groupId) {
		super();
		this.groupView = groupView;
		this.groupId = groupId;
		
		JLabel title = new JLabel("Studenter i " + groupView.getGroupName(groupId));
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
		
		JComboBox<ComboBoxItem> comboBox = new JComboBox();
		List<Student> allStudents = groupView.getAllStudents();
		
		for(int i = 0; i < students.size(); i++) {
			for(int j = 0; j < allStudents.size(); j++) {
				if(students.get(i).getStudentId() == (allStudents.get(j).getStudentId())) {
					allStudents.remove(j);
				}
			}
		}
		
		for(Student student : students) {
			StudentListRow studentRow = new StudentListRow(student, this);
			add(studentRow);			
		}
		
		for(Student student : allStudents) {
			ComboBoxItem item = new ComboBoxItem(student.getStudentId(), student.getName());
			comboBox.addItem(item);
		}
		
		JButton createNewButton = new JButton("Lägg till en ny student");
		createNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createStudent(groupId);
			}
		});
		
		JButton backButton = new JButton("Gå tillbaka");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				groupView.show(groupId);
			}
		});
		
		JButton createButton = new JButton("Lägg till vald student");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
				comboBoxStudentId = item.getIndex();
				create();
			}
		});
		
		JButton deleteButton = new JButton("Ta bort vald elev från systemet");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ComboBoxItem item = (ComboBoxItem) comboBox.getSelectedItem();
				comboBoxStudentId = item.getIndex();
				deleteStudent(comboBoxStudentId);
			}
		});
		
		add(comboBox);
		add(createButton);
		add(deleteButton);
		add(createNewButton);
		add(backButton);
		setLayout(new GridLayout(0,1));
	}
	
	@Override
	public void show(int studentId) {
		groupView.showStudent(studentId, groupId);
	}
	
	@Override
	public void create() {
		groupView.insertStudent(comboBoxStudentId, groupId);
	}
	
	public void createStudent(int groupId) {
		groupView.createStudent(groupId);
	}

	public void delete(int studentId) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort studenten från gruppen?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			groupView.deleteStudentFromGroup(studentId, groupId);
		}
	}
	
	public void deleteStudent(int studentId) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort vald student från systemet?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			groupView.deleteStudent(studentId, groupId);
		}
	}
	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
}
