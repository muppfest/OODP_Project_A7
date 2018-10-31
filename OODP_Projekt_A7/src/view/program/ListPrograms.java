package view.program;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Program;
import view.program.ProgramListRow;
import view.IListPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ListPrograms extends JPanel implements IListPanel<Program> {
	private ProgramView programView;
	
	public ListPrograms(List<Program> programs, ProgramView programView) {
		super();
		this.programView = programView;
		
		JLabel title = new JLabel("Program");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel codeLabel = new JLabel("Programkod");
		codeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(codeLabel);
		headers.add(nameLabel);
		headers.add(new JLabel());
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,4));
		add(headers);
		
		for(Program program : programs) {
			ProgramListRow programRow = new ProgramListRow(this, program);
			add(programRow);
		}
		
		JButton createButton = new JButton("Lägg till program");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		
		add(createButton);
		setLayout(new GridLayout(0,1));	
	}

	@Override
	public void show(int id) {
		programView.show(id);
	}

	@Override
	public void create() {
		programView.create();
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort programmet?", "", dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			programView.delete(id);
		}
	}
}
