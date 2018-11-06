/**
 * Huvudvy för grupper gjord av Marcus
 */

package view.group;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.GroupController;
import model.Group;
import model.Moment;
import model.Student;
import view.IView;
import view.View;
import view.student.CreateStudent;
import view.student.ListStudents;
import view.student.ShowStudent;

public class GroupView extends JPanel implements IView<Group> {
	private View frame;
	private GroupController controller;
	
	private ListGroups listGroupsPanel;
	private ShowGroup showGroupPanel;
	private ListStudents listStudentsPanel;
	private CreateStudent createStudentPanel;
	private ShowStudent showStudentPanel;
	private CreateGroup createGroupPanel;
	
	public GroupView(View frame) {
		this.frame = frame;
		controller = new GroupController();
		list();
	}
	
	@Override
	public void list() {
		List<Group> groups = controller.listGroups();
		listGroupsPanel = new ListGroups(this, groups);
		removeAll();
		add(listGroupsPanel);
		frame.refresh();
	}
	
	public void listStudents(int groupId) {
		List<Student> students = controller.listStudents(groupId);						
		listStudentsPanel = new ListStudents(this, students, groupId);
		removeAll();
		add(listStudentsPanel);
		frame.refresh();
	}
	
	@Override
	public void create() {
		createGroupPanel = new CreateGroup(this);
		removeAll();
		add(createGroupPanel);
		frame.refresh();
	}
	
	public void createStudent(int groupId) {
		createStudentPanel = new CreateStudent(this, groupId);
		removeAll();
		add(createStudentPanel);
		frame.refresh();
	}
	
	@Override
	public void show(int id) {
		Group g = controller.ShowGroup(id);
		showGroupPanel = new ShowGroup(this, g);
		removeAll();
		add(showGroupPanel);
		frame.refresh();
	}

	@Override
	public void insert(Group group) {
		if(controller.insertGroup(group)) {
			JOptionPane.showMessageDialog(frame,
				    "Gruppen Lades till.");
					show(group.getGroupId());
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}

	public void showStudent(int studentId, int groupId) {
		Student s = controller.ShowStudent(studentId);
		showStudentPanel = new ShowStudent(this, s, groupId);
		removeAll();
		add(showStudentPanel);
		frame.refresh();
	}
	
	@Override
	public void update(Group group) {
		if(controller.updateGroup(group)) {
			JOptionPane.showMessageDialog(frame,
				    "Gruppen uppdaterades.");
					show(group.getGroupId());
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}

	public void updateStudent(Student student, int groupId) {
		if(controller.updateStudent(student)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten uppdaterades.");
					showStudent(student.getStudentId(), groupId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	@Override
	public void delete(int id) {
		if(controller.deleteGroup(id)) {
			JOptionPane.showMessageDialog(frame,
				    "Gruppen togs bort.");
					list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	public void insertStudent(int studentId, int groupId) {
		if(controller.insertStudent(studentId, groupId)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten lades till i gruppen.");
					listStudents(groupId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	public void insertNewStudent(Student s, int groupId) {
		if(controller.insertNewStudent(s, groupId)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten lades till i gruppen.");
					listStudents(groupId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}				
	}
		
	public void deleteStudent(int studentId, int groupId) {
		if(controller.deleteStudent(studentId)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten togs bort från gruppen.");
					listStudents(groupId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}	
	}
	
	public void deleteStudentFromGroup(int studentId, int groupId) {
		if(controller.deleteStudentFromGroup(studentId, groupId)) {
			JOptionPane.showMessageDialog(frame,
				    "Studenten togs bort från gruppen.");
					listStudents(groupId);
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}
	
	public String getGroupName(int groupId) {
		return controller.getGroupName(groupId);
	}
	
	public String getCourseNameFromMoment(int momentId) {
		return controller.getCourseNameFromMoment(momentId);
	}
	
	public List<Student> getAllStudents() {
		return controller.getAllStudents();
	}
	
	public List<Moment> getAllMoments() {
		return controller.getAllMoments();
	}
}
