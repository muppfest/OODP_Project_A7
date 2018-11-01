package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import controller.StudentController;
import group.GroupView;
import model.Observable;
import model.person.Student;
import view.course.CourseView;
import view.moment.MomentView;
import view.program.ProgramView;
import view.student.StudentView;

public class View extends JFrame implements Observer {
	private StudentView studentView;
	private CourseView courseView;
	private MomentView momentView;
	private ProgramView programView;
	private GroupView groupView;
	
	private JScrollPane scrollPane;
	private JPanel buttonPanel;
	private final JLabel title = new JLabel("Studentapplikationen");
	
	public View() {		
		studentView = new StudentView(this);
		courseView = new CourseView(this);
		momentView = new MomentView(this);
		programView = new ProgramView(this);
		groupView = new GroupView(this);
		
		title.setFont(new Font("Arial", Font.BOLD, 18));
				
		setSize(800,600);
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
		
		JButton groupButton = new JButton("Grupper");
		groupButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				scrollPane = new JScrollPane(groupView);
				add(buttonPanel, BorderLayout.NORTH);
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				groupView.list();
				refresh();
			}
		});
		
		buttonPanel = new JPanel();
		
		buttonPanel.add(title, BorderLayout.NORTH);
		buttonPanel.add(studentButton);
		buttonPanel.add(courseButton);
		buttonPanel.add(programButton);
		buttonPanel.add(groupButton);
		
		add(buttonPanel, BorderLayout.NORTH);
		JPanel test = new JPanel();
		test.add(programView);
		test.add(courseView);
		refresh();
	}
	
	public void changePanel(JPanel panel) {
		getContentPane().removeAll();
		scrollPane = new JScrollPane(panel);
		add(buttonPanel, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
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

	public StudentView getStudentView() {
		return studentView;
	}

	public void setStudentView(StudentView studentView) {
		this.studentView = studentView;
	}

	public CourseView getCourseView() {
		return courseView;
	}

	public void setCourseView(CourseView courseView) {
		this.courseView = courseView;
	}

	public MomentView getMomentView() {
		return momentView;
	}

	public void setMomentView(MomentView momentView) {
		this.momentView = momentView;
	}

	public ProgramView getProgramView() {
		return programView;
	}

	public void setProgramView(ProgramView programView) {
		this.programView = programView;
	}
	
	
}