package com.skillstorm.avionrapide.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StateDAOImpl implements StateDAO{

	/*public static void main(String[] args) {
		StateDAO dao = new StateDAOImpl();
		System.out.println(dao.getStateAbbrev("Ohio"));
	}*/
	
	private static final String FIND_STATE_ABBREV = "select state_abbrev from state where state_name = ?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getStateAbbrev(String stateName) {
		String stateAbbrev = null;
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_STATE_ABBREV);
			stmt.setString(1, stateName);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			stateAbbrev = rs.getString("state_abbrev");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stateAbbrev;
	}

}
