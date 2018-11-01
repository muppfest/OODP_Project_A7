package view.teacher;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.person.Teacher;
import view.IShowPanel;
import view.course.CourseView;
import view.moment.ListMoments;

public class ShowTeacher extends JPanel implements IShowPanel<Teacher>{
	private CourseView courseView;
	private ListMoments listMoments;
	
	private int id;
	private JTextField name;
	private JTextField email;
	private JTextField phoneNr;
	private JTextField office;
	
	private JButton editButton = new JButton("Redigera");
	private JButton saveButton = new JButton("Spara ändringar");
	private JButton cancelButton = new JButton("Avbryt");
	
	private JLabel title = new JLabel("Lärare");
	
	public ShowTeacher(CourseView courseView, Teacher teacher) {
		super();
		this.courseView = courseView;
		
		id = teacher.getTeacherId();
		name = new JTextField(teacher.getName());
		email = new JTextField(teacher.getEmail());
		phoneNr = new JTextField(teacher.getPhoneNr());
		office = new JTextField(teacher.getOffice());
		
		name.setEditable(false);
		email.setEditable(false);
		phoneNr.setEditable(false);
		office.setEditable(false);
		
		JLabel nameLabel = new JLabel("Namn");
		JLabel emailLabel = new JLabel("E-postadress");
		JLabel phoneNrLabel = new JLabel("Telefonnummer");
		JLabel officeLabel = new JLabel("Kontorsrum");
		
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}
