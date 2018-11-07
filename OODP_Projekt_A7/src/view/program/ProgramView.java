/**
 * Huvudvyn för för program 
 * Gjord av Marcus Vretling Pistelli
 */

package view.program;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ProgramController;
import model.Course;
import model.Program;
import view.IView;
import view.View;

public class ProgramView extends JPanel implements IView<Program> {
	private View frame;
	private ProgramController controller;
	
	private ListPrograms listProgramsPanel;
	private ShowProgram showProgramPanel;
	private CreateProgram createProgramPanel;
	private ListProgramCourses listProgramCoursesPanel;
		
	public ProgramView(View frame) {
		this.frame = frame;
		controller = new ProgramController();
		list();
	}

	public View getFrame() {
		return frame;
	}
	
	public void insertProgramCourse(int courseId, int programId) {
		if(controller.insertCourseIntoProgram(courseId, programId)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursen lades till i programmet.");
					listCourses(programId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	public void deleteCourseFromProgram(int courseId, int programId) {
		if(controller.deleteCourseFromProgram(courseId, programId)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursen togs bort från programmet.");
					listCourses(programId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	public List<Course> getListOfCourses() {
		List<Course> courses = controller.listCourses();
		return courses;
	}
	
	public void listCourses(int programId) {
		List<Course> courses = controller.listCoursesInProgram(programId);
		listProgramCoursesPanel = new ListProgramCourses(this, courses, programId);
		removeAll();
		add(listProgramCoursesPanel);
		frame.refresh();
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
	
	public void createCourse() {
		
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
	
	public String getProgramName(int programId) {
		return controller.showProgram(programId).getName();
	}
}
