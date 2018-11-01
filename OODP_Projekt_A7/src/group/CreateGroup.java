package group;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.ICreatePanel;

public class CreateGroup extends JPanel implements ICreatePanel {
	GroupView groupView;
	
	public CreateGroup(GroupView groupView) {
		this.groupView = groupView;
		
		JLabel title = new JLabel("Lägg till grupp");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		JLabel nameLabel = new JLabel("Gruppnamn");
	}

}
