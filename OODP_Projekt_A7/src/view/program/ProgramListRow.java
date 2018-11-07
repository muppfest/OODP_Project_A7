/**
 * Delvy för att skapa rader åt listning av program 
 * Gjord av Marcus Vretling Pistelli
 */

package view.program;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Program;

public class ProgramListRow extends JPanel {
	private JPanel listPrograms;
	private JLabel programCode;
	private JLabel programName;

	private JButton showButton = new JButton("Visa program");
	private JButton deleteButton = new JButton("Ta bort program");
	
	public ProgramListRow(ListPrograms listPrograms, Program program) {
		super();
		this.listPrograms = listPrograms;
		
		programCode = new JLabel(program.getProgramCode());
		programName = new JLabel(program.getName());
		
		setLayout(new GridLayout(0,4));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listPrograms.show(program.getProgramId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listPrograms.delete(program.getProgramId());
			}
		});
		
		add(programCode);
		add(programName);
		add(showButton);
		add(deleteButton);
	}
}
