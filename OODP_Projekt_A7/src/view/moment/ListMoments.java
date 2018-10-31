package view.moment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Course;
import model.Moment;
import view.IListPanel;
import view.course.CourseView;
import view.course.ShowCourse;

public class ListMoments extends JPanel implements IListPanel<Moment> {
	private CourseView courseView;
	
	public ListMoments(CourseView courseView, Course course) {
		super();
		this.courseView = courseView;
		
		JLabel title = new JLabel("Kursmoment inom " + course.getName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel typeLabel = new JLabel("Kursmoment");
		typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel dateLabel = new JLabel("Slutdatum");
		dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel creditLabel = new JLabel("Högskolepoäng");
		creditLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(typeLabel);
		headers.add(creditLabel);
		headers.add(dateLabel);
		headers.add(new JLabel());
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,5));
		add(headers);
		
		for(Moment moment : course.getMoments()) {
			MomentListRow momentRow = new MomentListRow(moment, this);
			add(momentRow);
		}
		
		JButton createButton = new JButton("Lägg till kursmoment");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		
		JButton backButton = new JButton("Gå tillbaka");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.show(course.getCourseId());
			}
		});
		
		add(createButton);
		add(backButton);
		setLayout(new GridLayout(0,1));
	}
		
	@Override
	public void show(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
