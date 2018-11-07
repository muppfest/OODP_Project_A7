/**
 * DAO-klass som implementerar ett simpelt DAO-interface med de mest basala CRUD-metoderna för att hämta och manipulera data i kurstabellen i databasen. 
 * Hämtar och manipulerar även kopplingstabellen programcourses. 
 * 
 * Gjord av Marcus
 */

package dao;

import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnectionManager;
import model.Course;

public class CourseDao implements IDao<Course> {
	private DbConnectionManager db = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	private int lastInsertedId;
	
	public CourseDao() {
		db = db.getInstance();
	}

	@Override
	public Course getById(int id) {
		Course c = new Course();
		String statementString = "SELECT courseId, courseCode, name, description, finalGrade, courseScheduleURL, coursePlanURL, startDate FROM courses WHERE courseId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				c.setCourseId(rs.getInt(1));
				c.setCourseCode(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDescription(rs.getString(4));
				c.setFinalGrade(rs.getString(5));
				c.setCourseScheduleURL(rs.getString(6));
				c.setCoursePlanURL(rs.getString(7));
				c.setStartDate(rs.getDate(8));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		db.closeConnection();
		return c;
	}

	@Override
	public List<Course> getAll() {
		List<Course> clist = new ArrayList<Course>();
		String sqlQueryString = "SELECT courseId, courseCode, name, description, finalGrade, courseScheduleURL, coursePlanURL, startDate FROM courses";
		
		try {
			rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Course c = new Course();
				c.setCourseId(rs.getInt(1));
				c.setCourseCode(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDescription(rs.getString(4));
				c.setFinalGrade(rs.getString(5));
				c.setCourseScheduleURL(rs.getString(6));
				c.setCoursePlanURL(rs.getString(7));
				c.setStartDate(rs.getDate(8));
				clist.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		db.closeConnection();
		return clist;
	}

	@Override
	public boolean insert(Course object) {
		String statementString = "INSERT INTO courses (courseCode, name, description, finalGrade, courseScheduleURL, coursePlanURL, startDate) VALUES (?,?,?,?,?,?,?) RETURNING courseId";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getCourseCode());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setString(4, object.getFinalGrade());
			preparedStatement.setString(5, object.getCourseScheduleURL().toString());
			preparedStatement.setString(6, object.getCoursePlanURL().toString());			
			preparedStatement.setDate(7, object.getStartDate());
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
		String statementString = "DELETE FROM courses WHERE courseId = ?";
		
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
	public boolean update(Course object) {
		String statementString = "UPDATE courses SET courseCode = ?, name = ?, description = ?, finalGrade = ?, courseScheduleURL = ?, coursePlanURL = ?, startDate = ? WHERE courseId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getCourseCode());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setString(4, object.getFinalGrade());
			preparedStatement.setString(5, object.getCourseScheduleURL().toString());
			preparedStatement.setString(6, object.getCoursePlanURL().toString());
			preparedStatement.setDate(7, object.getStartDate());
			preparedStatement.setInt(8, object.getCourseId());
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
	
	public List<Course> getAllCoursesFromProgram(int programId) {
		String statementString = "SELECT courseId FROM programcourses WHERE programId = ?";
		List<Course> courses = new ArrayList<Course>();
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, programId);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Course c = new Course();
				c.setCourseId(rs.getInt(1));
				courses.add(c);
			}
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0; i < courses.size(); i++) {
			courses.set(i, getById(courses.get(i).getCourseId()));
		}
		
		return courses;
	}
	
	public boolean insertCourseIntoProgram(int courseId, int programId) {
		String statementString = "INSERT INTO programcourses (courseId, programId) VALUES (?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.setInt(2, programId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean deleteCoursesFromProgram(int courseId, int programId) {
		String statementString = "DELETE FROM programcourses WHERE courseId = ? AND programId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.setInt(2, programId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
}
