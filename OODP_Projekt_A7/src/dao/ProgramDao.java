/**
 * DAO-klass för att hämta och manipulera data i programtabellen i databasen. 
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
import model.Program;

import model.Program;

public class ProgramDao implements IDao<Program> {
	
	private DbConnectionManager db = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	
	public ProgramDao() {
		db = db.getInstance();
	}

	@Override
	public Program getById(int id) {
		Program p = new Program();
		String statementString = "SELECT programId, programCode, name, description FROM programs WHERE programId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				p.setProgramId(rs.getInt(1));
				p.setProgramCode(rs.getString(2));
				p.setName(rs.getString(3));
				p.setDescription(rs.getString(4));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return p;
	}

	@Override
	public List<Program> getAll() {
		List<Program> plist = new ArrayList<Program>();
		
		String sqlQueryString = "SELECT programId, programCode, name, description FROM programs";
		
		try {
			rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Program p = new Program();
				p.setProgramId(rs.getInt(1));
				p.setProgramCode(rs.getString(2));
				p.setName(rs.getString(3));
				p.setDescription(rs.getString(4));
				plist.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return plist;
	}

	@Override
	public boolean insert(Program object) {
		String statementString = "INSERT INTO programs (programCode, name, description) VALUES (?,?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getProgramCode());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(int id) {
		String statementString = "DELETE FROM programs WHERE programId = ?";
		
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
	public boolean update(Program object) {
		String statementString = "UPDATE programs SET programCode = ?, name = ?, description = ? WHERE programId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getProgramCode());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setInt(4, object.getProgramId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	/*
	public List<Course> getCoursesInProgram(int programId) {
		List<Course> courses = new ArrayList<Course>();
		String statementString = "SELECT programCoursesId, courseId, programId FROM programcourses WHERE programId = ?";
				
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, programId);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return courses;
	}
	
	public boolean addCourseToProgram(int courseId, int programId) {
		String statementString = "INSERT INTO programcourses (courseId, programId) VALUES (?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.setInt(2, programId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	} */
}
