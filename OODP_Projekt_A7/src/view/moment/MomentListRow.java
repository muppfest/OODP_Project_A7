/**
 * Delvy för att lista kursmoment i en specifik kurs gjord av Marcus Vretling Pistelli
 */

package view.moment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Moment;

public class MomentListRow extends JPanel {
	private JPanel listMoments;
	private JLabel type;
	private JLabel credit;
	
	private JButton showButton = new JButton("Visa kursmoment");
	private JButton deleteButton = new JButton("Ta bort kursmoment");
	
	public MomentListRow(Moment moment, ListMoments listMoments) {
		this.listMoments = listMoments;
		
		type = new JLabel(moment.getType());
		credit = new JLabel(Double.toString(moment.getCredit()) + " hp");
				
		setLayout(new GridLayout(0,4));
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listMoments.show(moment.getMomentId());
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listMoments.delete(moment.getMomentId());
			}
		});
		
		add(type);
		add(credit);
		add(showButton);
		add(deleteButton);
	}
}
