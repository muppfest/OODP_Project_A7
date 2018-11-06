/**
 * Delvy f�r att visa kursmoment gjord av Marcus Vretling Pistelli
 */

package view.moment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Moment;
import view.IShowPanel;
import view.course.CourseView;

public class ShowMoment extends JPanel implements IShowPanel<Moment> {
	private CourseView courseView;
	
	private int momentId;
	private int courseId;
	private JTextField momentCode;
	private JTextField momentType;
	private JTextField description;
	private JTextField credit;
	private JTextField grade;
	private JTextField date;
	private JTextField place;
	
	private JButton editButton = new JButton("Redigera");
	private JButton saveButton = new JButton("Spara �ndringar");
	private JButton cancelButton = new JButton("Avbryt");
	private JButton backButton = new JButton("G� tillbaka");
		
	public ShowMoment(CourseView courseView, Moment moment) {
		super();
		this.courseView = courseView;
		
		JLabel title = new JLabel(moment.getType() + " i " + moment.getCourse().getName());
		title.setFont(new Font("Arial", Font.BOLD, 20));
		
		momentId = moment.getMomentId();
		courseId = moment.getCourse().getCourseId();
		momentCode = new JTextField(moment.getMomentCode());
		momentType = new JTextField(moment.getType());
		description = new JTextField(moment.getDescription());
		credit = new JTextField(String.valueOf(moment.getCredit()));
		grade = new JTextField(moment.getGrade());
		date = new JTextField();
		if(moment.getDate() != null) {
			date.setText(moment.getDate().toString());
		}
		place = new JTextField(moment.getPlace());
		
		momentCode.setEditable(false);
		momentType.setEditable(false);
		description.setEditable(false);
		credit.setEditable(false);
		grade.setEditable(false);
		date.setEditable(false);
		place.setEditable(false);
		
		JLabel codeLabel = new JLabel("Kursmomentskod");
		codeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel typeLabel = new JLabel("Typ");
		typeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel dateLabel = new JLabel("Slutdatum");
		dateLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel creditLabel = new JLabel("H�gskolepo�ng");
		creditLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel gradeLabel = new JLabel("Betyg");
		gradeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel placeLabel = new JLabel("Plats");
		placeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel descriptionLabel = new JLabel("Beskrivning");
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		add(title);
		add(codeLabel);
		add(momentCode);
		add(typeLabel);
		add(momentType);
		add(creditLabel);
		add(credit);
		add(placeLabel);
		add(place);
		add(dateLabel);
		add(date);
		add(gradeLabel);
		add(grade);
		add(descriptionLabel);
		add(description);
		
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
		
		setLayout(new GridLayout(0,1));
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!date.getText().isEmpty()) {
					if(IsValidDateFormat(date.getText())) {
						save();
					} else {
						JOptionPane.showMessageDialog(courseView, "Datumet m�ste vara i f�ljande format: ����-mm-dd");
					}
				} else {
					save();
				}
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
				courseView.listMoments(courseId);				
			}
		});
				
		add(editButton);
		add(saveButton);
		add(cancelButton);
		add(backButton);
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
		Moment m = new Moment();
		m.setCourseId(courseId);
		m.setMomentId(momentId);
		m.setCredit(Double.parseDouble(credit.getText()));
		m.setDate(Date.valueOf(date.getText()));
		m.setGrade(grade.getText());
		m.setMomentCode(momentCode.getText());
		m.setDescription(description.getText());
		m.setPlace(place.getText());
		m.setType(momentType.getText());
		
		editButton.setEnabled(true);
		saveButton.setEnabled(false);
		cancelButton.setEnabled(false);
		disableFields();
		
		courseView.updateMoment(m);
	}

	@Override
	public void enableFields() {
		momentCode.setEditable(true);
		momentType.setEditable(true);
		description.setEditable(true);
		credit.setEditable(true);
		grade.setEditable(true);
		date.setEditable(true);
		place.setEditable(true);		
	}

	@Override
	public void disableFields() {
		momentCode.setEditable(false);
		momentType.setEditable(false);
		description.setEditable(false);
		credit.setEditable(false);
		grade.setEditable(false);
		date.setEditable(false);
		place.setEditable(false);
	}

	@Override
	public void cancel() {
		saveButton.setVisible(false);;
		cancelButton.setVisible(false);;
		editButton.setVisible(true);;
		disableFields();
		refresh();		
	}

	@Override
	public void refresh() {
		revalidate();
		repaint();		
	}

	
	public boolean IsValidDateFormat(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		try {
			java.util.Date d = dateFormat.parse(date);
			if(dateFormat.format(d).equals(date)) {
				return true;
			}
		} catch (ParseException ex) {
			return false;
		}
		return false;			
	}
}
