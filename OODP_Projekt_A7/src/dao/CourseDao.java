/**
 * DAO-klass för att hämta och manipulera data i coursetabellen i databasen. 
 * 
 * Gjord av Marcus
 */

package dao;

import java.net.MalformedURLException;
import java.net.URL;
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
				c.setCourseScheduleURL(new URL(rs.getString(6)));
				c.setCoursePlanURL(new URL(rs.getString(7)));
				c.setStartDate(rs.getDate(8));
			}
			
		} catch (SQLException | MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
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
				c.setCourseScheduleURL(new URL(rs.getString(6)));
				c.setCoursePlanURL(new URL(rs.getString(7)));
				c.setStartDate(rs.getDate(8));
				clist.add(c);
			}
		} catch (SQLException | MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
		return clist;
	}

	@Override
	public boolean insert(Course object) {
		String statementString = "INSERT INTO courses (courseCode, name, description, finalGrade, courseScheduleURL, coursePlanURL, startDate) VALUES (?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getCourseCode());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setString(4, object.getFinalGrade());
			preparedStatement.setString(5, object.getCourseScheduleURL().toString());
			preparedStatement.setString(6, object.getCoursePlanURL().toString());
			preparedStatement.setDate(7, object.getStartDate());
			preparedStatement.executeUpdate();
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
}
