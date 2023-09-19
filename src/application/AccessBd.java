package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DB;

public class AccessBd {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from users");
			
			while (rs.next()) {
				System.out.println(rs.getString("position") + ", " + rs.getString("nickname"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		DB.getConnection();
		DB.closeConnetction();
		
	}

}