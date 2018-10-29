package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import controller.StudentController;
import model.Observable;
import model.person.Student;

public class View extends JFrame implements Observer {
	private StudentView studentView;
	private CourseView courseView;
	private JPanel buttonPanel;
	private final JLabel title = new JLabel("Studentapplikationen");
	
	public View() {		
		studentView = new StudentView(this);
		courseView = new CourseView(this);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		JButton studentButton = new JButton("Studenter");
		studentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				add(buttonPanel, BorderLayout.NORTH);
				add(studentView, BorderLayout.CENTER);
				refresh();
			}
		});
		
		JButton courseButton = new JButton("Kurser");
		courseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				add(buttonPanel, BorderLayout.NORTH);
				add(courseView, BorderLayout.CENTER);
				refresh();
			}
		});
		
		buttonPanel = new JPanel();
		
		buttonPanel.add(title, BorderLayout.WEST);
		buttonPanel.add(studentButton);
		buttonPanel.add(courseButton);
		
		add(buttonPanel, BorderLayout.NORTH);
	}
	
	@Override
	public void notify(Observable observable) {
		// TODO Auto-generated method stub
		
	}
	
	public void refresh() {
		revalidate();
		repaint();
		pack();
	}
}