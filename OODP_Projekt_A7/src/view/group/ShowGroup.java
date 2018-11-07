/**
 * Vy för att visa och redigera grupper. Även möjlighet att visa kopplade studenter.
 * Implementerar interfacet IShowPanel. 
 * Gjord av Marcus och bearbetad av Felix
 */

package view.group;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Group;
import view.IShowPanel;

public class ShowGroup extends JPanel implements IShowPanel<Group> {
	private GroupView groupView;
	private int groupId;
	private int momentId;
	
	private JTextField name;
	private JTextField description;
	
	private JButton editButton = new JButton("Redigera grupp");
	private JButton saveButton = new JButton("Spara ändringar");
	private JButton cancelButton = new JButton("Avbryt");
	private JButton backButton = new JButton("Gå tillbaka");
	private JButton showStudentsButton = new JButton("Visa gruppens studenter");
	
	private JLabel title;
	
	public ShowGroup(GroupView groupView, Group group) {
		this.groupView = groupView;
		groupId = group.getGroupId();
		momentId = group.getMomentId();
		
		JLabel nameLabel = new JLabel("Gruppnamn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel descriptionLabel = new JLabel("Beskrivning");
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		name = new JTextField(group.getName());
		description = new JTextField(group.getDescription());
		
		title = new JLabel(group.getName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(title);
		add(nameLabel);
		add(name);
		add(descriptionLabel);
		add(description);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				edit();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				groupView.list();			
			}
		});
		
		showStudentsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				groupView.listStudents(groupId);
			}
		});
		
		add(editButton);
		add(saveButton);
		add(cancelButton);
		add(showStudentsButton);
		add(backButton);
		
		disableFields();
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
		
		setLayout(new GridLayout(0,1));
	}
	
	
	@Override
	public void edit() {
		editButton.setVisible(false);
		saveButton.setVisible(true);
		cancelButton.setVisible(true);
		enableFields();
		refresh();
	}

	@Override
	public void save() {
		if(!name.getText().isEmpty()) {
		Group g = new Group();
		g.setGroupId(groupId);
		g.setMomentId(momentId);
		g.setDescription(description.getText());
		g.setName(name.getText());
		groupView.update(g);
		} else {
			JOptionPane.showMessageDialog(this, "Gruppens namn får inte vara tomt");
		}
	}

	@Override
	public void enableFields() {
		name.setEditable(true);
		description.setEditable(true);
	}

	@Override
	public void disableFields() {
		name.setEditable(false);
		description.setEditable(false);		
	}

	@Override
	public void cancel() {
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
		editButton.setVisible(true);
		disableFields();
		refresh();		
	}

	@Override
	public void refresh() {
		revalidate();
		repaint();		
	}

}
