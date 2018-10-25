import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProgramDao;
import dao.StudentDao;
import db.DbConnectionManager;
import model.Program;
import model.person.Student;

public class test {

	public static void main(String[] args) throws SQLException {
		StudentDao d = new StudentDao();
		
		List<Student> slist = new ArrayList<Student>();
		slist = d.getAll();
		for(Student student : slist) {
			student.printStudent();
			System.out.println();
		}
		
		ProgramDao dp = new ProgramDao();
		List<Program> plist = new ArrayList<Program>();
		plist = dp.getAll();
		
		for(Program program : plist) {
			program.printProgram();
			System.out.println();
		}
	}
}
