package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import controller.StudentController;
import model.Observable;
import model.person.Student;

public class StudentTest extends JFrame implements Observer {
	private StudentController controller;
	private ShowStudentPanel showStudentPanel;
	private ListStudentsPanel listStudentsPanel;
	private CreateStudentPanel createStudentPanel;
	
	public StudentTest() {
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		controller = new StudentController();
		listStudents();
	}
	
	
	@Override
	public void notify(Observable observable) {
		// TODO Auto-generated method stub
		
	}
	
	public void listStudents() {
		List<Student> students = controller.ListStudents();
				
		ActionListener createListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("create");
			}
		};
		
		listStudentsPanel = new ListStudentsPanel(students, this);
		listStudentsPanel.setVisible(true);
		getContentPane().removeAll();
		add(listStudentsPanel);
		refresh();
	}
	
	public void createStudent() {
		createStudentPanel = new CreateStudentPanel(this);
		getContentPane().removeAll();
		add(createStudentPanel);
		refresh();
	}
	
	public void showStudent(int id) {
		Student student = controller.ShowStudent(id);		
		showStudentPanel = new ShowStudentPanel(student, this);
		getContentPane().removeAll();
		add(showStudentPanel);
		refresh();
	}
	
	public void refresh() {
		revalidate();
		repaint();
		pack();
	}
	
	public void insertStudent(Student s) {
		if(controller.insertStudent(s)) {
			JOptionPane.showMessageDialog(this,
				    "Studenten lades till.");
			listStudents();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Något gick fel.");
		}
	}
	
	public void updateStudent() {
		Student s = new Student();
		s = showStudentPanel.save();
		
		if(controller.updateStudent(s)) {
			JOptionPane.showMessageDialog(this,
				    "Studenten uppdaterades.");
		} else {
			JOptionPane.showMessageDialog(this,
				    "Något gick fel.");
		}
	}
	
	public void deleteStudent(int id) {
		if(controller.deleteStudent(id)) {
			JOptionPane.showMessageDialog(this,
				    "Studenten togs bort.");
			listStudents();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Något gick fel.");
		}
	}
}