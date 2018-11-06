package view.group;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Group;
import view.IListPanel;

public class ListGroups extends JPanel implements IListPanel<Group> {
	private GroupView groupView;
	
	private JLabel title = new JLabel("Grupper");
	
	public ListGroups(GroupView groupView, List<Group> groups) {
		this.groupView = groupView;
		
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel nameLabel = new JLabel("Grupp");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel courseLabel = new JLabel("Kurs");
		courseLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel momentTypeLabel = new JLabel("Kursmoment");
		momentTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel headers = new JPanel();
		headers.add(nameLabel);
		headers.add(courseLabel);
		headers.add(momentTypeLabel);
		headers.add(new JLabel());
		headers.add(new JLabel());
		headers.setLayout(new GridLayout(0,5));
		add(headers);
		
		for(Group group : groups) {
			GroupListRow groupRow = new GroupListRow(this, group);
			add(groupRow);
		}
		
		setLayout(new GridLayout(0,1));
		
		JButton createButton = new JButton("Lägg till ny grupp");
		
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		
		add(createButton);
	}
	
	@Override
	public void show(int id) {
		groupView.show(id);
	}

	@Override
	public void create() {
		groupView.create();
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		groupView.delete(id);
	}

}
