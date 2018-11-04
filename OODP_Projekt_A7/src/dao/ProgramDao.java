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
	private int lastInsertedId;
	
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
			db.closeConnection();
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
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return plist;
	}

	@Override
	public boolean insert(Program object) {
		String statementString = "INSERT INTO programs (programCode, name, description) VALUES (?,?,?) RETURNING programId";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getProgramCode());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
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
		String statementString = "DELETE FROM programs WHERE programId = ?";
		
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
	public boolean update(Program object) {
		String statementString = "UPDATE programs SET programCode = ?, name = ?, description = ? WHERE programId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getProgramCode());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setInt(4, object.getProgramId());
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
}
