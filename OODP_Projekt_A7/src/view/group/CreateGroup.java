/**
 * Skapa-vy för grupper gjord av Marcus
 */

package view.group;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Group;
import model.Moment;
import view.ComboBoxItem;

public class CreateGroup extends JPanel {
	private GroupView groupView;
	
	private JButton saveButton = new JButton("Lägg till grupp");
	private JButton backButton = new JButton("Gå tillbaka");
	
	public CreateGroup(GroupView groupView) {
		this.groupView = groupView;
		
		JTextField name = new JTextField();
		JTextField description = new JTextField();
		
		JComboBox<ComboBoxItem> comboBox = new JComboBox();
		List<Moment> moments = groupView.getAllMoments();
		
		for(Moment moment : moments) {
			ComboBoxItem item = new ComboBoxItem(moment.getMomentId(), groupView.getCourseNameFromMoment(moment.getMomentId()) + " - " + moment.getType());
			comboBox.addItem(item);
		}
		
		JLabel nameLabel = new JLabel("Gruppnamn");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel descriptionLabel = new JLabel("Beskrivning");
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel momentLabel = new JLabel("Kursmoment");
		momentLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		add(nameLabel);
		add(name);
		add(descriptionLabel);
		add(description);
		add(momentLabel);
		add(comboBox);
		add(saveButton);
		add(backButton);
		
		setLayout(new GridLayout(0,1));
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupView.list();
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(groupView, "Namn måste fyllas i");
				} else {
					Group g = new Group();
					g.setDescription(description.getText());
					g.setName(name.getText());
					groupView.insert(g);
				}
			}
		});
	}
}
