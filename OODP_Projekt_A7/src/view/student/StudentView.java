package view.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.StudentController;
import model.person.Student;
import view.IView;
import view.View;

public class StudentView extends JPanel implements IView<Student> {
	private View frame;
	private StudentController controller;
	
	private ShowStudent showStudentPanel;
	private ListStudents listStudentsPanel;
	private CreateStudent createStudentPanel;
		
	public StudentView(View frame) {
		this.frame = frame;
		controller = new StudentController();
		list();
	}
	
	@Override
	public void list() {
		List<Student> students = controller.listStudents();						
		listStudentsPanel = new ListStudents(students, this);
		removeAll();
		add(listStudentsPanel);
		frame.refresh();
	}
	@Override
	public void create() {
		createStudentPanel = new CreateStudent(this);
		removeAll();
		add(createStudentPanel);
		frame.refresh();
	}
	@Override
	public void show(int id) {
		Student student = controller.ShowStudent(id);		
		showStudentPanel = new ShowStudent(student, this);
		removeAll();
		add(showStudentPanel);
		frame.refresh();
	}
	@Override
	public void insert(Student s) {
		if(controller.insertStudent(s)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten lades till.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}
	}
	@Override
	public void update(Student s) {		
		if(controller.updateStudent(s)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten uppdaterades.");
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}
	}
	@Override
	public void delete(int id) {
		if(controller.deleteStudent(id)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten togs bort.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}
	}
}
