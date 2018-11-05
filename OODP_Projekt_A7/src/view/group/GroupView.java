package view.group;

import java.util.List;

import javax.swing.JPanel;

import controller.GroupController;
import model.Group;
import view.IView;
import view.View;

public class GroupView extends JPanel implements IView<Group> {
	private View frame;
	private GroupController controller;
	
	private ListGroups listGroupsPanel;
	
	public GroupView(View frame) {
		this.frame = frame;
		controller = new GroupController();
	}
	
	@Override
	public void list() {
		List<Group> groups = controller.listGroups();
		listGroupsPanel = new ListGroups(this, groups);
		removeAll();
		add(listGroupsPanel);
		frame.refresh();
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Group object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Group object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
