/**
 * DAO-klass för att hämta och manipulera data i lärartabellen i databasen.
 * Hanterar även courseteachers-tabellen i databasen.  
 * 
 * Gjord av Marcus
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnectionManager;
import model.Course;
import model.Teacher;

public class TeacherDao implements IDao<Teacher> {
	private DbConnectionManager db = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	private int lastInsertedId;
	
	public TeacherDao() {
		db = db.getInstance();
	}

	public Teacher getById(int id) {
		Teacher t = new Teacher();
		String statementString = "SELECT teacherId, name, email, phonenr, office FROM teachers WHERE teacherId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				t.setTeacherId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setPhoneNr(rs.getString(4));
				t.setOffice(rs.getString(5));
			}
			
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return t;
	}

	@Override
	public List<Teacher> getAll() {
		List<Teacher> tlist = new ArrayList<Teacher>();
		String sqlQueryString = "SELECT teacherId, name, email, phoneNr, office FROM teachers";
		
		try {
			rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Teacher t = new Teacher();
				t.setTeacherId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setPhoneNr(rs.getString(4));
				t.setOffice(rs.getString(5));
				tlist.add(t);
			}
			
			db.closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tlist;
	}

	@Override
	public boolean insert(Teacher object) {
		String statementString = "INSERT INTO teachers (name, email, phoneNr, office) VALUES (?,?,?,?) RETURNING teacherId";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getEmail());
			preparedStatement.setString(3, object.getPhoneNr());
			preparedStatement.setString(4, object.getOffice());
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
		String statementString = "DELETE FROM teachers WHERE teacherId = ?";
		
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
	public boolean update(Teacher object) {
		String statementString = "UPDATE teachers SET name = ?, email = ?, phoneNr = ?, office = ? WHERE teacherId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getEmail());
			preparedStatement.setString(3, object.getPhoneNr());
			preparedStatement.setString(4, object.getOffice());
			preparedStatement.setInt(5, object.getTeacherId());
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean insertTeacherToCourse(int courseId, int teacherId) {
		String statementString = "INSERT INTO courseteachers (courseId, teacherId) VALUES (?,?)";
		
		if(!teacherAlreadyExistInCourse(courseId, teacherId)) {
			try {
				preparedStatement = db.preparedStatement(statementString);
				preparedStatement.setInt(1, courseId);
				preparedStatement.setInt(2, teacherId);
				preparedStatement.executeUpdate();
				db.closeConnection();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
			return true;
		} else {
			System.out.println("Något gick fel");
			return false;
		}
	}
	
	public boolean deleteAllTeachersFromCourse(int courseId) {
		String statementString = "DELETE FROM courseteachers WHERE courseId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean deleteTeacherFromCourse(int courseId, int teacherId) {
		String statementString = "DELETE FROM courseteachers WHERE courseId = ? AND teacherId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.setInt(2, teacherId);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean deleteAllCoursesFromTeacher(int teacherId) {
		String statementString = "DELETE FROM courseteachers WHERE teacherId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, teacherId);
			preparedStatement.executeUpdate();
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public List<Teacher> getAllTeachersFromCourse(int courseId) {
		String statementString = "SELECT teacherId FROM courseteachers WHERE courseId = ?";
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int teacherId = rs.getInt(1);
				Teacher t = new Teacher();
				t.setTeacherId(teacherId);
				teachers.add(t);
			} 			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0; i < teachers.size(); i++) {
			teachers.set(i, getById(teachers.get(i).getTeacherId()));
		}
		
		db.closeConnection();
		return teachers;
	}
	
	public List<Course> getAllCoursesFromTeacher(int teacherId) {
		String statementString = "SELECT courseId FROM courseteachers WHERE teacherId = ?";
		List<Course> courses = new ArrayList<Course>();
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, teacherId);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Course c = new Course();
				c.setCourseId(rs.getInt(1));
				courses.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		db.closeConnection();
		return courses;
	}
	
	public boolean teacherAlreadyExistInCourse(int courseId, int teacherId) {
		String statementString = "SELECT * FROM courseteachers WHERE courseId = ? AND teacherId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.setInt(2, teacherId);
			rs = preparedStatement.executeQuery();
			
			if(rs.getFetchSize() > 0) {
				db.closeConnection();
				return true;
			}
			db.closeConnection();
			return false;
		} catch (SQLException e) {
			System.out.println("Något gick fel");
			return false;
		}
	}
	
	public int getLastInsertTeacherId() {
		return lastInsertedId;
	}
}
