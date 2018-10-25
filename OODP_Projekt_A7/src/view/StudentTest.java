package view;

import javax.swing.*;

import controller.StudentController;
import model.Observable;
import model.person.Student;

public class StudentTest extends JFrame implements Observer {
	private StudentController controller;
	
	public StudentTest() {
		controller = new StudentController();
		
		
	}
	
	@Override
	public void notify(Observable observable) {
		// TODO Auto-generated method stub
		
	}

}
