package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import database.DB;
import database.DbIntegrityException;
import design.UserRegisterPanel;

public class UserRegistration extends UserRegisterPanel {
	public UserRegistration() {
	}

	private static final long serialVersionUID = 1L;

	public static void Register() {
		
		String name = UserRegisterPanel.insertName.getText();
		String id = UserRegisterPanel.insertId.getText();
		String position = UserRegisterPanel.insertPosition.getText();
		String nickName = UserRegisterPanel.insertNick.getText();
		Integer idNumber = Integer.parseInt(id);
		
		String password = new String(UserRegisterPanel.passwordField.getPassword());
		String passwordConfirm = new String(UserRegisterPanel.passwordFieldConfirm.getPassword());
		
		Connection conn = null;
		PreparedStatement st = null;
		
		if (password.equals(passwordConfirm)) {
			try {
				conn = DB.getConnection();
			    st = conn.prepareStatement(
					    "INSERT INTO users " 
					    + "(name, ID, position, nickname, password)"
					    + "VALUES"
					    + "(?, ?, ? , ?, ?)");
			    st.setString(1, name);
			    st.setInt(2, idNumber);
			    st.setString(3, position);
			    st.setString(4, nickName);
			    st.setString(5, password);
			    
			    st.executeUpdate();
			    JOptionPane.showMessageDialog(null, "Usuário cadastrado com SUSSEÇO!!!");
		    }
			
			catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERRO ao tentar cadastrar novo usuário!!!");
			}
			
			finally {
				DB.closeStatement(st);
				//DB.closeConnetction();
			}
		}
		UserRegisterPanel.insertName.setText("");
		UserRegisterPanel.insertId.setText("");
		UserRegisterPanel.insertPosition.setText("");
		UserRegisterPanel.insertNick.setText("");
		UserRegisterPanel.passwordField.setText("");
		UserRegisterPanel.passwordFieldConfirm.setText("");
	}
	
	public static void consultUser() {
		Integer idConsult = Integer.parseInt(UserRegisterPanel.idConsult.getText());
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
		    ResultSet rs = st.executeQuery(
		    		"SELECT name, position FROM users WHERE ID = '" + idConsult + "';"
		    		);
		    while(rs.next()) {
		    	UserRegisterPanel.nameFunction.setText(rs.getString(1) + " / " + rs.getString(2));
		        }
		    
		    }
		    catch (SQLException e) {
			    e.printStackTrace();
		    }
		
		finally {
			DB.closeStatement(st);
			//DB.closeConnetction();
		}
	}
	
	
	public static void deleteUser() {
		
		Integer idConsult = Integer.parseInt(UserRegisterPanel.idConsult.getText());
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("DELETE FROM users WHERE ID = ?");
		    st.setInt(1, idConsult);
		    st.executeUpdate();		    
		    
		    JOptionPane.showMessageDialog(null, "Usuário EXCUÍDO com SUSSEÇO!!!");
		    
		    }
		    catch (SQLException e) {
			    throw new DbIntegrityException(e.getMessage());
		    }
		
		finally {
			DB.closeStatement(st);
			//DB.closeConnetction();
		}
	}
}