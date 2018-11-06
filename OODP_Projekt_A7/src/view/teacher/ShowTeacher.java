/**
 * Vy f�r att visa l�rare gjord av Marcus Vretling Pistelli
 */

package view.teacher;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Teacher;
import view.IShowPanel;
import view.course.CourseView;
import view.moment.ListMoments;

public class ShowTeacher extends JPanel implements IShowPanel<Teacher>{
	private CourseView courseView;
	private ListMoments listMoments;
	
	private int teacherId;
	private int courseId;
	
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField office;
	
	private JButton editButton = new JButton("Redigera");
	private JButton saveButton = new JButton("Spara �ndringar");
	private JButton cancelButton = new JButton("Avbryt");
	private JButton backButton = new JButton("G� tillbaka");
	
	private JLabel title;
	
	public ShowTeacher(CourseView courseView, Teacher teacher, int courseId) {
		super();
		this.courseView = courseView;
		
		teacherId = teacher.getTeacherId();
		this.courseId = courseId; 
		
		title = new JLabel(teacher.getName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		
		name = new JTextField(teacher.getName());
		email = new JTextField(teacher.getEmail());
		phoneNr = new JTextField(teacher.getPhoneNr());
		office = new JTextField(teacher.getOffice());
		
		name.setEditable(false);
		email.setEditable(false);
		phoneNr.setEditable(false);
		office.setEditable(false);
		
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel emailLabel = new JLabel("E-postadress");
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		phoneNrLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel officeLabel = new JLabel("Kontorsrum");
		officeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		add(title);
		add(nameLabel);
		add(name);
		add(emailLabel);
		add(email);
		add(phoneNrLabel);
		add(phoneNr);
		add(officeLabel);
		add(office);
		
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
		
		setLayout(new GridLayout(0, 1));
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				save();
			}
		});
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				edit();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseView.listTeachers(courseId);			
			}
		});
				
		add(editButton);
		add(saveButton);
		add(cancelButton);
		add(backButton);
	}

	@Override
	public void edit() {
		editButton.setVisible(false);
		saveButton.setVisible(true);
		cancelButton.setVisible(true);
		enableFields();
		refresh();
	}

	@Override
	public void save() {
		Teacher t = new Teacher();
		t.setTeacherId(teacherId);
		t.setName(name.getText());
		t.setEmail(email.getText());
		t.setOffice(office.getText());
		t.setPhoneNr(phoneNr.getText());
		
		editButton.setEnabled(true);
		saveButton.setEnabled(false);
		cancelButton.setEnabled(false);
		disableFields();
		
		courseView.updateTeacher(t, courseId);
	}

	@Override
	public void enableFields() {
		name.setEditable(true);
		email.setEditable(true);
		phoneNr.setEditable(true);
		office.setEditable(true);
	}

	@Override
	public void disableFields() {
		name.setEditable(false);
		email.setEditable(false);
		phoneNr.setEditable(false);
		office.setEditable(false);
	}

	@Override
	public void cancel() {
		saveButton.setVisible(false);;
		cancelButton.setVisible(false);;
		editButton.setVisible(true);;
		disableFields();
		refresh();	
	}

	@Override
	public void refresh() {
		revalidate();
		repaint();	
	}
}
