/**
 * View för detaljer av studenter gjord av: Marcus
 */

package view;

import java.util.List;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.person.Student;

public class ShowStudent extends JPanel implements IShowPanel<Student> {
	private StudentView studentView;
	
	private int id;
	private int programId;
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField address;
	private JTextField city;
	private JTextField programName;
	
	private JButton editButton = new JButton("Redigera");
	private JButton saveButton = new JButton("Spara ändringar");
	private JButton cancelButton = new JButton("Avbryt");
	
	private JLabel title = new JLabel("Student");
	
	public ShowStudent(Student student, StudentView studentView) {
		super();
		this.studentView = studentView;
		title.setFont(new Font("Arial", Font.BOLD, 20));
		
		id = student.getStudentId();
		programId = student.getProgramId();
		name = new JTextField(student.getName());
		email = new JTextField(student.getEmail());
		phoneNr = new JTextField(student.getPhoneNr());
		address = new JTextField(student.getAddress());
		city = new JTextField(student.getCity());
		programName = new JTextField(student.getProgram().getName());
		
		name.setEditable(false);
		email.setEditable(false);
		phoneNr.setEditable(false);
		address.setEditable(false);
		city.setEditable(false);
		programName.setEditable(false);
			
		JLabel nameLabel = new JLabel("Namn");
		JLabel emailLabel = new JLabel("E-postadress");
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		JLabel addressLabel = new JLabel("Adress");
		JLabel cityLabel = new JLabel("Ort");
		JLabel programLabel = new JLabel("Program");
		
		add(title);
		add(new JLabel());
		add(nameLabel);
		add(name);
		add(emailLabel);
		add(email);
		add(phoneNrLabel);
		add(phoneNr);
		add(addressLabel);
		add(address);
		add(cityLabel);
		add(city);
		add(programLabel);
		add(programName);
		
		setLayout(new GridLayout(0,1));
		
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
		
		JButton backButton = new JButton("Gå tillbaka");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentView.list();				
			}
		});
		
		add(editButton);
		add(saveButton);
		add(cancelButton);
		add(backButton);
		
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
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
		Student s = new Student();
		s.setStudentId(id);	
		s.setProgramId(programId);
		s.setName(name.getText());
		s.setAddress(address.getText());
		s.setCity(city.getText());
		s.setEmail(email.getText());
		s.setPhoneNr(phoneNr.getText());
		
		editButton.setVisible(true);
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
		disableFields();
		
		studentView.update(s);
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
	public void enableFields() {
		name.setEditable(true);
		email.setEditable(true);
		phoneNr.setEditable(true);
		address.setEditable(true);
		city.setEditable(true);
	}

	@Override
	public void disableFields() {
		name.setEditable(false);
		email.setEditable(false);
		phoneNr.setEditable(false);
		address.setEditable(false);
		city.setEditable(false);
	}

	@Override
	public void refresh() {
		revalidate();
		repaint();
	}
}
