/**
 * DAO-klass för att hämta och manipulera data i coursetabellen i databasen. 
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
	
	public GroupDao() {
		db = db.getInstance();
	}

	@Override
	public Group getById(int id) {
		Group g = new Group();
		String statementString = "SELECT groupId, name, description FROM groups WHERE groupId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				g.setGroupId(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setDescription(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return g;
	}

	@Override
	public List<Group> getAll() {
		List<Group> glist = new ArrayList<Group>();
		String sqlQueryString = "SELECT groupId, name, description FROM groups";
		
		try {
			rs = db.executeQuery(sqlQueryString);
			
			while(rs.next()) {
				Group g = new Group();
				g.setGroupId(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setDescription(rs.getString(3));
				glist.add(g);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return glist;
	}

	@Override
	public boolean insert(Group object) {
		String statementString = "INSERT INTO groups (name, description) VALUES (?,?)";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getDescription());
			preparedStatement.executeUpdate();
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Group object) {
		String statementString = "UPDATE groups SET name = ?, description = ? WHERE groupId = ?";
		
		try {
			preparedStatement = db.preparedStatement(statementString);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getDescription());
			preparedStatement.setInt(3, object.getGroupId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
}
