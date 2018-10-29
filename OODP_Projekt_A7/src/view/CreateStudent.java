/**
 * View för skapande av studenter gjord av: Marcus
 */

package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.person.Student;

public class CreateStudent extends JPanel implements ICreatePanel {
	private StudentView studentView;
	
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField address;
	private JTextField city;
	private JTextField programName;
	
	private JButton saveButton = new JButton("Lägg till student");
	private JButton backButton = new JButton("Gå tillbaka");
	
	public CreateStudent(StudentView studentView) {
		this.studentView = studentView;
		
		JLabel title = new JLabel("Lägg till student");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel nameLabel = new JLabel("Fullständigt namn");
		JLabel emailLabel = new JLabel("E-postadress");
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		JLabel addressLabel = new JLabel("Adress");
		JLabel cityLabel = new JLabel("Ort");
		
		name = new JTextField();
		email = new JTextField();
		phoneNr = new JTextField();
		address = new JTextField();
		city = new JTextField();
				
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(studentView,
						    "Namn måste fyllas i.");
				} else {
					createStudent();
				}				
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentView.list();
			}
		});
		
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
		add(saveButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
	}
	
	public void createStudent() {
		Student s = new Student();
		s.setName(name.getText());
		s.setAddress(address.getText());
		s.setCity(city.getText());
		s.setEmail(email.getText());
		s.setPhoneNr(phoneNr.getText());
		
		studentView.insert(s);
	}
}
