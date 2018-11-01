package group;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Group;
import view.course.CourseListRow;

public class GroupListRow extends JPanel {
	private JPanel listGroups;
	private JLabel groupNameLabel;
	private JLabel groupSizeLabel;
	
	private JButton showButton = new JButton("Visa grupp");
	private JButton deleteButton = new JButton("Ta bort grupp");

	public GroupListRow(Group group, ListGroups listGroups) {
		super();
		this.listGroups = listGroups;
		
		String groupSize = String.valueOf(group.getStudents().size());
		
		
		groupNameLabel = new JLabel(group.getName());
		groupSizeLabel = new JLabel(groupSize);
		
		setLayout(new GridLayout(0,4));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listGroups.show(group.getGroupId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listGroups.delete(group.getGroupId());
			}
		});
		
		add(groupNameLabel);
		add(groupSizeLabel);
		add(showButton);
		add(deleteButton);
	}
}
