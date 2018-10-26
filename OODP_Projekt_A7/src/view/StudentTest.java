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

	
	public StudentTest() {
		controller = new StudentController();
		
		List<Student> slist = controller.ListStudents();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(1000,1000));
		
		for(Student student : slist) {
			JLabel sname = new JLabel(student.getName());
			JLabel semail = new JLabel(student.getEmail());
			JLabel sphone = new JLabel(student.getPhoneNr());
			JButton sbutton = new JButton("Detaljer");
			sbutton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					showStudent(student.getStudentId());
				}
			});
			
			JPanel panel = new JPanel();
			
			panel.add(sname);
			panel.add(semail);
			panel.add(sphone);
			panel.add(sbutton);

			add(panel);
			setLayout(new FlowLayout());
		}
	}
	
	@Override
	public void notify(Observable observable) {
		// TODO Auto-generated method stub
		
	}
	
	public void showStudent(int id) {
		Student student = controller.ShowStudent(id);
		
		ActionListener saveListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStudent();
			}
		};
		
		showStudentPanel = new ShowStudentPanel(student, saveListener);
		getContentPane().removeAll();
		add(showStudentPanel);
		refresh();
	}
	
	public void refresh() {
		revalidate();
		repaint();
	}
	
	public void updateStudent() {
		Student s = new Student();
		s = showStudentPanel.save();
		
		if(controller.updateStudent(s)) {
			JOptionPane.showMessageDialog(this,
				    "Studenten uppdaterades.");
		} else {
			JOptionPane.showMessageDialog(this,
				    "Något gick fel med uppdateringen.");
		}
	}
}
