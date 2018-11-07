/**
 * Vy för att skapa program 
 * Skapad av Marcus Vretling Pistelli och bearbetad av Felix
 */

package view.program;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Program;

public class CreateProgram extends JPanel {
	private ProgramView programView;
	
	private JTextField programCode;
	private JTextField programName;
	private JTextField description;
	
	private JButton saveButton = new JButton("Lägg till program");
	private JButton backButton = new JButton("Gå tillbaka");
	
	public CreateProgram(ProgramView programView) {
		this.programView = programView;
		
		JLabel title = new JLabel("Lägg till program");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel codeLabel = new JLabel("Programkod");
		codeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel descriptionLabel = new JLabel("Beskrivning");
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		programCode = new JTextField();
		programName = new JTextField();
		description = new JTextField();
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(programName.getText().isEmpty() || programCode.getText().isEmpty()){
					JOptionPane.showMessageDialog(programView,
						    "Programmets namn, programkod måste fyllas i.");
				} else {
					create();
				}				
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				programView.list();
			}
		});
		
		add(codeLabel);
		add(programCode);
		add(nameLabel);
		add(programName);
		add(descriptionLabel);
		add(description);
		add(saveButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
		
	}
	
	public void create() {
		Program p = new Program();
		
		p.setName(programName.getText());
		p.setProgramCode(programCode.getText());
		p.setDescription(description.getText());
		
		programView.insert(p);
	}
}
