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
	private JFrame frame = new JFrame();
	
	public StudentTest() {
		controller = new StudentController();
		
		List<Student> slist = controller.ListStudents();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1000,1000));
		
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

			frame.add(panel);
			frame.setLayout(new FlowLayout());
		}
	}
	
	@Override
	public void notify(Observable observable) {
		// TODO Auto-generated method stub
		
	}
	
	public void showStudent(int id) {
		Student student = controller.ShowStudent(id);
		
		ShowStudentPanel panel = new ShowStudentPanel(student);
		
		frame.getContentPane().removeAll();
		frame.add(panel);
		frame.revalidate();
		frame.repaint();
	}
}
