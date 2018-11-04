/**
 * Huvudvy f�r hela view-delen gjord av Marcus Vretling Pistelli
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Observable;
import view.course.CourseView;
import view.program.ProgramView;
import view.student.StudentView;

public class View extends JFrame implements Observer {
	private StudentView studentView;
	private CourseView courseView;
	private ProgramView programView;
	
	private JScrollPane scrollPane;
	private JPanel buttonPanel;
	private final JLabel title = new JLabel("Studentapplikationen");
	
	public View() {		
		studentView = new StudentView(this);
		courseView = new CourseView(this);
		programView = new ProgramView(this);
		
		title.setFont(new Font("Arial", Font.BOLD, 18));
		
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
		
		setMinimumSize(new Dimension(1024, 768));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Studentapplikationen");
				
		JButton studentButton = new JButton("Studenter");
		studentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				scrollPane = new JScrollPane(studentView);
				add(buttonPanel, BorderLayout.NORTH);
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				studentView.list();
				refresh();
			}
		});
		
		JButton courseButton = new JButton("Kurser");
		courseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				scrollPane = new JScrollPane(courseView);
				add(buttonPanel, BorderLayout.NORTH);
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				courseView.list();
				refresh();
			}
		});
		
		JButton programButton = new JButton("Program");
		programButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				scrollPane = new JScrollPane(programView);
				add(buttonPanel, BorderLayout.NORTH);
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				programView.list();
				refresh();
			}
		});
		
		buttonPanel = new JPanel();
		
		buttonPanel.add(title, BorderLayout.NORTH);
		buttonPanel.add(studentButton);
		buttonPanel.add(courseButton);
		buttonPanel.add(programButton);
		
		add(buttonPanel, BorderLayout.NORTH);
		
		getContentPane().add(courseView, BorderLayout.CENTER);
		courseView.list();
		refresh();
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