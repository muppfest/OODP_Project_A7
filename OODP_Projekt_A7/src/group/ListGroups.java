package group;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Course;
import model.Group;
import view.IListPanel;
import view.course.CourseListRow;

public class ListGroups extends JPanel implements IListPanel {
	private GroupView groupView;
	
	public ListGroups(List<Group> glist, GroupView groupView) {
		this.groupView = groupView;
		
		JLabel title = new JLabel("Grupper");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel groupNameLabel = new JLabel("Gruppnamn");
		groupNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel groupSizeLabel = new JLabel("Antal medlemmar");
		groupSizeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(groupNameLabel);
		headers.add(groupSizeLabel);
		headers.add(new JLabel());
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,4));
		add(headers);
		
		for(Group group : glist) {
			GroupListRow courseRow = new GroupListRow(group, this);
			add(courseRow);
		}
		
		JButton createButton = new JButton("Lägg till kurs");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
	}

	@Override
	public void show(int id) {
		
	}

	@Override
	public void create() {
		groupView.create();
	}

	@Override
	public void sort() {
		
	}

	@Override
	public void delete(int id) {
		
	}

}
