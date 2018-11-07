/**
 * View för skapande av studenter gjord av: Felix
 */

package view.student;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Student;
import view.ICreatePanel;
import view.group.GroupView;

public class CreateStudent extends JPanel implements ICreatePanel {
	private GroupView groupView;
	
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField address;
	private JTextField city;
	private JTextField programName;
	
	private JButton saveButton = new JButton("Lägg till student");
	private JButton backButton = new JButton("Gå tillbaka");
	
	public CreateStudent(GroupView groupView, int groupId) {
		this.groupView = groupView;
		
		JLabel title = new JLabel("Lägg till student i gruppen " + groupView.getGroupName(groupId));
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel nameLabel = new JLabel("Fullständigt namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel emailLabel = new JLabel("E-postadress");
		emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		phoneNrLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel addressLabel = new JLabel("Adress");
		addressLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel cityLabel = new JLabel("Ort");
		cityLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		name = new JTextField();
		email = new JTextField();
		phoneNr = new JTextField();
		address = new JTextField();
		city = new JTextField();
				
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(groupView,
						    "Namn måste fyllas i.");
				} else {
					createStudent(groupId);
				}				
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				groupView.listStudents(groupId);
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
	
	public void createStudent(int groupId) {
		Student s = new Student();
		s.setName(name.getText());
		s.setAddress(address.getText());
		s.setCity(city.getText());
		s.setEmail(email.getText());
		s.setPhoneNr(phoneNr.getText());
		
		groupView.insertNewStudent(s, groupId);
	}
}
