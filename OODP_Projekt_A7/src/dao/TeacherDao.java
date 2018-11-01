/**
 * DAO-klass för att hämta och manipulera data i teachertabellen i databasen. 
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
import model.person.Teacher;

public class TeacherDao implements IDao<Teacher> {
	private DbConnectionManager db = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	
	public TeacherDao() {
		db = db.getInstance();
	}

	@Override
	public Teacher getById(int id) {
		Teacher t = new Teacher();
		String statementString = "SELECT teacherId, name, email, office FROM teachers WHERE teacherId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				t.setTeacherId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setOffice(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return t;
	}

	@Override
	public List<Teacher> getAll() {
		List<Teacher> tlist = new ArrayList<Teacher>();
		String sqlQueryString = "SELECT teacherId, name, email, office FROM teachers";
		
		try {
			rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Teacher t = new Teacher();
				t.setTeacherId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setOffice(rs.getString(4));
				tlist.add(t);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tlist;
	}

	@Override
	public boolean insert(Teacher object) {
		String statementString = "INSERT INTO teachers (name, email, office) VALUES (?,?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getEmail());
			preparedStatement.setString(3, object.getOffice());
			preparedStatement.executeUpdate();
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Teacher object) {
		String statementString = "UPDATE teachers SET name = ?, email = ?, office = ? WHERE teacherId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getEmail());
			preparedStatement.setString(3, object.getOffice());
			preparedStatement.setInt(4, object.getTeacherId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean insertTeacherToCourse(int courseId, int teacherId) {
		String statementString = "INSERT INTO courseteachers (courseId, teacherId) VALUES (?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.setInt(2, teacherId);
			preparedStatement.executeUpdate();
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
			preparedStatement.setInt(1, teacherId);
			preparedStatement.setInt(2, courseId);
			preparedStatement.executeUpdate();
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
		return teachers;
	}
	
	public List<Course> getAllCoursesFromTeacher(int teacherId) {
		String statementString = "SELECT courseId FROM courseteachers WHERE courseId = ?";
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
		return courses;
	}
}
