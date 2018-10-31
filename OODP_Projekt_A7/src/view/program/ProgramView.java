package view.program;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ProgramController;
import model.Course;
import model.Program;
import view.IView;
import view.View;
import view.moment.ListMoments;

public class ProgramView extends JPanel implements IView<Program> {
	private View frame;
	private ProgramController controller;
	
	private ListPrograms listProgramsPanel;
	private ShowProgram showProgramPanel;
	private CreateProgram createProgramPanel;
	
		
	public ProgramView(View frame) {
		this.frame = frame;
		controller = new ProgramController();
		list();
	}

	public View getFrame() {
		return frame;
	}
	
	@Override
	public void list() {
		List<Program> programs = controller.listProgram();
		listProgramsPanel = new ListPrograms(programs, this);
		removeAll();
		add(listProgramsPanel);
		frame.refresh();
	}
	
	@Override
	public void create() {
		createProgramPanel = new CreateProgram(this);
		removeAll();
		add(createProgramPanel);
		frame.refresh();
	}


	@Override
	public void show(int id) {
		Program program = controller.showProgram(id);
		showProgramPanel = new ShowProgram(program, this);
		removeAll();
		add(showProgramPanel);
		frame.refresh();
	}

	@Override
	public void insert(Program p) {
		if(controller.insertProgram(p)) {
			JOptionPane.showMessageDialog(frame,
				    "Programmet lades till.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}

	@Override
	public void update(Program p) {
		if(controller.updateProgram(p)) {
			JOptionPane.showMessageDialog(frame,
				    "Programmet uppdaterades.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}		

	@Override
	public void delete(int id) {
		if(controller.deleteProgram(id)) {
			JOptionPane.showMessageDialog(frame,
				    "Programmet togs bort.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}
	}

}
