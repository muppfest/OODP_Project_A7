package view;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.person.Student;

public class ShowStudentPanel extends JPanel implements IShowPanel<Student> {
	private int id;
	private int programId;
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField address;
	private JTextField city;
	private JTextField programName;
	
	private JButton editButton = new JButton("Redigera");
	private JButton saveButton = new JButton("Spara");
	private JButton cancelButton = new JButton("Avbryt");
	
	public ShowStudentPanel(Student student, ActionListener saveListener) {
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
				
		add(name);
		add(email);
		add(phoneNr);
		add(address);
		add(city);
		add(programName);
		
		
		saveButton.addActionListener(saveListener);
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
		
		add(editButton);
		add(saveButton);
		add(cancelButton);
		
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
	}

	@Override
	public void edit() {	
		editButton.setVisible(false);;
		saveButton.setVisible(true);;
		cancelButton.setVisible(true);;
		enableFields();
		refresh();
	}

	@Override
	public Student save() {		
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
		
		return s;
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
