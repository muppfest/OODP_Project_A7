import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import db.DbConnectionManager;
import model.person.Student;

public class test {

	public static void main(String[] args) throws SQLException {
		StudentDao d = new StudentDao();
		Student s = new Student();
		s = d.getById(2);
		
		s.printStudent();
		
		List<Student> slist = new ArrayList<Student>();
		slist = d.getAll();
		for(Student student : slist) {
			student.printStudent();
		}
		
		Student s3 = d.getById(6);
		s3.setName("Olof Olofsson");
		d.update(s3);
	}

}
