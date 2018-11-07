/**
 * Huvudvy för hela view-delen. 
 * Tanken är att alla olika huvudpaneler ska ligga i denna frame. 
 * Utifrån klick på knappar i knapp-panelen ändras vyn. 
 * 
 * gjord av Marcus Vretling Pistelli
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
import view.group.GroupView;
import view.program.ProgramView;

public class View extends JFrame implements Observer {
	private View view = this;
	private GroupView groupView;
	private CourseView courseView;
	private ProgramView programView;
	
	private JScrollPane scrollPane;
	private JPanel buttonPanel;
	private final JLabel title = new JLabel("Studentapplikationen");
	
	public View() {		
		courseView = new CourseView(this);
		
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
				
		JButton groupButton = new JButton("Grupper");
		groupButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				groupView = new GroupView(view);
				getContentPane().removeAll();
				scrollPane = new JScrollPane(groupView);
				add(buttonPanel, BorderLayout.NORTH);
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				groupView.list();
				refresh();
			}
		});
		
		JButton courseButton = new JButton("Kurser");
		courseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView = new CourseView(view);
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
				programView = new ProgramView(view);
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
		buttonPanel.add(groupButton);
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