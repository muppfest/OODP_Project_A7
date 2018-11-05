package view.group;

import javax.swing.JPanel;

import model.Group;
import view.IView;
import view.View;

public class GroupView extends JPanel implements IView<Group> {
	private View frame;
	private GroupController controller;
	
	public GroupView(View frame) {
		this.frame = frame;
	}
}
