/**
 * DAO-klass för att hämta och manipulera data i momenttabellen i databasen. 
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
import model.Moment;

public class MomentDao implements IDao<Moment> {
	private DbConnectionManager db = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	
	
	public MomentDao() {
		db = db.getInstance();
	}
	
	@Override
	public Moment getById(int id) {
		Moment m = new Moment();
		String statementString = "SELECT momentId, momentCode, type, description, grade, date, credit, place, courseId FROM moments WHERE momentId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				m.setMomentId(rs.getInt(1));
				m.setMomentCode(rs.getString(2));
				m.setType(rs.getString(3));
				m.setDescription(rs.getString(4));
				m.setGrade(rs.getString(5));
				m.setDate(rs.getDate(6));
				m.setCredit(rs.getDouble(7));
				m.setPlace(rs.getString(8));
				m.setCourseId(rs.getInt(9));
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return m;
	}
	
	@Override
	public List<Moment> getAll() {
		List<Moment> mlist = new ArrayList<Moment>();
		String sqlQueryString = "SELECT momentId, momentCode, type, description, grade, date, credit, place, courseId FROM moments";
		
		try {
			rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Moment m = new Moment();
				m.setMomentId(rs.getInt(1));
				m.setMomentCode(rs.getString(2));
				m.setType(rs.getString(3));
				m.setDescription(rs.getString(4));
				m.setGrade(rs.getString(5));
				m.setDate(rs.getDate(6));
				m.setCredit(rs.getDouble(7));
				m.setPlace(rs.getString(8));
				m.setCourseId(rs.getInt(9));
				mlist.add(m);
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return mlist;
	}

	@Override
	public boolean insert(Moment object) {
		String statementString = "INSERT INTO moments (momentCode, type, description, grade, date, credit, place, courseId) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getMomentCode());
			preparedStatement.setString(2, object.getType());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setString(4, object.getGrade());
			preparedStatement.setDate(5, object.getDate());
			preparedStatement.setDouble(6, object.getCredit());
			preparedStatement.setString(7, object.getPlace());
			preparedStatement.setInt(8, object.getCourseId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(int id) {
		String statementString = "DELETE FROM moments WHERE momentId = ?";
		
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
	
	public boolean deleteAllCourseMoments(int courseId) {
		String statementString = "DELETE FROM moments WHERE courseId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, courseId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Moment object) {
		String statementString = "UPDATE moments SET momentCode = ?, type = ?, description = ?, grade = ?, date = ?, credit = ?, place = ? WHERE courseId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getMomentCode());
			preparedStatement.setString(2, object.getType());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setString(4, object.getGrade());
			preparedStatement.setDate(5, object.getDate());
			preparedStatement.setDouble(6, object.getCredit());
			preparedStatement.setString(7, object.getPlace());
			preparedStatement.setInt(8, object.getCourseId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	
}
