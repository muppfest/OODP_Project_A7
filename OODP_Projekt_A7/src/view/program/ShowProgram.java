/**
 * Vy för att visa program gjord av Marcus Vretling Pistelli
 */

package view.program;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Program;
import view.IShowPanel;
import view.course.CourseView;
import view.course.ListCourses;

public class ShowProgram extends JPanel implements IShowPanel<Program> {
	private ProgramView programView;
	
	private int id;
	private JTextField programCode;
	private JTextField programName;
	private JTextField description;
	
	private JButton editButton = new JButton("Redigera program");
	private JButton showCoursesButton = new JButton("Visa kurser inom programmet");
	private JButton saveButton = new JButton("Spara ändringar");
	private JButton cancelButton = new JButton("Avbryt");
	
	public ShowProgram(Program program, ProgramView programView) {
		super();
		this.programView = programView;
				
		id = program.getProgramId();
		programCode = new JTextField(program.getProgramCode());
		programName = new JTextField(program.getName());
		description = new JTextField(program.getDescription());
		
		programCode.setEditable(false);
		programName.setEditable(false);
		description.setEditable(false);
		
		JLabel codeLabel = new JLabel("Programkod");
		JLabel nameLabel = new JLabel("Namn");
		JLabel descriptionLabel = new JLabel("Beskrivning");
		
		
		add(codeLabel);
		add(programCode);
		add(nameLabel);
		add(programName);
		add(descriptionLabel);
		add(description);
		
		setLayout(new GridLayout(0,1));
		
		showCoursesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				programView.listCourses(program.getProgramId());
			}
		});
		
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
				programView.list();				
			}
		});
		
		add(editButton);
		add(showCoursesButton);
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
		Program p = new Program();
		p.setProgramId(id);
		p.setName(programName.getText());
		p.setProgramCode(programCode.getText());
		p.setDescription(description.getText());
		
		editButton.setEnabled(true);
		saveButton.setEnabled(false);
		cancelButton.setEnabled(false);
		disableFields();
		
		programView.update(p);
	}

	@Override
	public void enableFields() {
		programCode.setEditable(true);
		programName.setEditable(true);
		description.setEditable(true);
	}

	@Override
	public void disableFields() {
		programCode.setEditable(false);
		programName.setEditable(false);
		description.setEditable(false);
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
