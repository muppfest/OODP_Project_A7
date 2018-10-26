package view;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.person.Student;

public class ShowStudentPanel extends JPanel {
	private List<JTextField> textFields = new ArrayList<JTextField>();
	
	public ShowStudentPanel(Student student) {
		textFields.add(new JTextField(student.getName()));
		textFields.add(new JTextField(student.getEmail()));
		textFields.add(new JTextField(student.getPhoneNr()));
		textFields.add(new JTextField(student.getAddress()));
		textFields.add(new JTextField(student.getCity()));
		textFields.add(new JTextField(student.getProgram().getName()));
		
		for(JTextField textField : textFields) {
			textField.setEditable(false);
			add(textField);
		}
	}
}
