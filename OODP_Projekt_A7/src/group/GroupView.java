package group;

import java.util.List;

import javax.swing.JPanel;

import controller.GroupController;
import model.Group;
import view.IView;
import view.View;

public class GroupView extends JPanel implements IView {
	private View frame;
	private GroupController controller;
	
	private ListGroups listGroupsPanel;		
	private ShowGroup showGroupPanel;		
	private CreateGroup createGroupPanel;	

	public GroupView(View frame) {
		this.frame = frame;
		controller = new GroupController();
		list();
	}

	@Override
	public void list() {
		List<Group> glist = controller.listGroups();
		listGroupsPanel = new ListGroups(glist, this);
	}

	@Override
	public void create() {
		createGroupPanel = new CreateGroup(this);
	}

	@Override
	public void show(int id) {
		
	}

	@Override
	public void insert(Object object) {
		
	}

	@Override
	public void update(Object object) {
		
	}

	@Override
	public void delete(int id) {
		
	}

}
