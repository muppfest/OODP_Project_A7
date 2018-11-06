/**
 * DAO-klass för att hämta och manipulera data i studenttabellen i databasen. 
 * 
 * Gjord av Marcus
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import db.DbConnectionManager;
import model.Program;
import model.Student;

public class StudentDao implements IDao<Student> {

	private DbConnectionManager db = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	private int lastInsertedId;
	
	public StudentDao() {
		db = db.getInstance();
	}
	
	@Override
	public Student getById(int id) {
		Student s = new Student();
		String statementString = "SELECT studentId, programId, name, email, phoneNr, address, city FROM students WHERE studentId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				s.setStudentId(rs.getInt(1));
				s.setProgramId(rs.getInt(2));
				s.setName(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhoneNr(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setCity(rs.getString(7));
			}
			db.closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return s;
	}

	@Override
	public List<Student> getAll() {
		List<Student> slist = new ArrayList<Student>();
		String sqlQueryString = "SELECT studentId, name, email, phoneNr, address, city, programId FROM students";
		
		try {
				rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Student s = new Student();
				s.setStudentId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPhoneNr(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setCity(rs.getString(6));
				s.setProgramId(rs.getInt(7));
				slist.add(s);
			}
			db.closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return slist;
	}

	@Override
	public boolean insert(Student object) {
		String statementString = "INSERT INTO students (name, email, phoneNr, address, city) VALUES (?,?,?,?,?) RETURNING studentId";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getEmail());
			preparedStatement.setString(3, object.getPhoneNr());
			preparedStatement.setString(4, object.getAddress());
			preparedStatement.setString(5, object.getCity());
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				lastInsertedId = rs.getInt(1);
			}
			
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(int id) {
		String statementString = "DELETE FROM students WHERE studentId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Student object) {
		String statementString = "UPDATE students SET programId = ?, name = ?, email = ?, phoneNr = ?, address = ?, city = ? WHERE studentId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, object.getProgramId());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getEmail());
			preparedStatement.setString(4, object.getPhoneNr());
			preparedStatement.setString(5, object.getAddress());
			preparedStatement.setString(6, object.getCity());
			preparedStatement.setInt(7, object.getStudentId());
			preparedStatement.executeUpdate();
			db.closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public List<Student> getAllStudentsFromGroup(int groupId) {
		List<Student> students = new ArrayList<Student>();
		
		String statementString = "SELECT studentId FROM studentGroups WHERE groupId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, groupId);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setStudentId(rs.getInt(1));
				students.add(s);
			}
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0; i < students.size(); i++) {
			students.set(i, getById(students.get(i).getStudentId()));
		}
		
		return students;
	}
	
	public boolean insertStudentIntoGroup(int studentId, int groupId) {
		String statementString = "INSERT INTO studentgroups (studentId, groupId) VALUES (?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, groupId);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public int getLastInsertedId() {
		return lastInsertedId;
	}
	
	public boolean deleteStudentFromGroup(int groupId, int studentId) {
		String statementString = "DELETE FROM studentgroups WHERE groupId = ? AND studentId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, groupId);
			preparedStatement.setInt(2, studentId);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean deleteStudentFromAllGroups(int studentId) {
		String statementString = "DELETE FROM studentgroups WHERE studentId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, studentId);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean deleteAllStudentsFromGroup(int groupId) {
		String statementString = "DELETE FROM studentgroups WHERE groupId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, groupId);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
