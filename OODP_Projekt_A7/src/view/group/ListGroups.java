package view.group;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Group;
import view.IListPanel;

public class ListGroups extends JPanel implements IListPanel<Group> {
	private GroupView groupView;
	
	public ListGroups(GroupView groupView, List<Group> groups) {
		this.groupView = groupView;
		
		JLabel nameLabel = new JLabel("Gruppnamn");
		JLabel courseLabel = new JLabel("Kursnamn");
		JLabel momentTypeLabel = new JLabel("Kursmoment");
		
		for(Group group : groups) {
			GroupListRow groupRow = new GroupListRow(this, group);
			add(groupRow);
		}
	}
	
	@Override
	public void show(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
