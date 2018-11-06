/**
 * DAO-klass för att hämta och manipulera data i grupptabellen i databasen. 
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
import model.Group;

public class GroupDao implements IDao<Group> {
	private DbConnectionManager db = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	private int lastInsertedId;
	
	public GroupDao() {
		db = db.getInstance();
	}

	@Override
	public Group getById(int id) {
		Group g = new Group();
		String statementString = "SELECT groupId, momentId, name, description FROM groups WHERE groupId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				g.setGroupId(rs.getInt(1));
				g.setMomentId(rs.getInt(2));
				g.setName(rs.getString(3));
				g.setDescription(rs.getString(4));
			}
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return g;
	}

	@Override
	public List<Group> getAll() {
		List<Group> glist = new ArrayList<Group>();
		String sqlQueryString = "SELECT groupId, momentId, name, description FROM groups";
		
		try {
			rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Group g = new Group();
				g.setGroupId(rs.getInt(1));
				g.setMomentId(rs.getInt(2));
				g.setName(rs.getString(3));
				g.setDescription(rs.getString(4));
				glist.add(g);
			}
			db.closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return glist;
	}

	@Override
	public boolean insert(Group group) {
		String statementString = "INSERT INTO groups (momentId, name, description) VALUES (?,?,?) RETURNING groupId";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, group.getMomentId());
			preparedStatement.setString(2, group.getName());
			preparedStatement.setString(3, group.getDescription());
			rs = preparedStatement.executeQuery();

			if(rs.next()) {
				lastInsertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(int id) {
		String statementString = "DELETE FROM groups WHERE groupId = ?";
		
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
	public boolean update(Group object) {
		String statementString = "UPDATE groups SET momentId = ?, name = ?, description = ? WHERE groupId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, object.getMomentId());
			preparedStatement.setString(2, object.getName());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setInt(4, object.getGroupId());
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
