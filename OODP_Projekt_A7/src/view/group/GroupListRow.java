/**
 * Delvy för att skapa rader i ListGroups. 
 * Gjord av Felix
 */

package view.group;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Group;

public class GroupListRow extends JPanel {
	private JPanel ListGroups;
	private JLabel groupName;
	private JLabel momentType;
	private JLabel courseName;
	
	private JButton showButton;
	private JButton deleteButton;
		
	public GroupListRow(ListGroups listGroups, Group group) {
		this.ListGroups = listGroups;
				
		groupName = new JLabel(group.getName());
		momentType = new JLabel(group.getMoment().getType());
		courseName = new JLabel(group.getMoment().getCourse().getName());
		
		setLayout(new GridLayout(0,5));
		
		showButton = new JButton("Visa grupp");
		deleteButton = new JButton("Ta bort grupp");
		
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
		
		add(groupName);
		add(courseName);
		add(momentType);
		add(showButton);
		add(deleteButton);
	}
}
