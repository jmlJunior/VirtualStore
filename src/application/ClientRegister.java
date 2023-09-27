package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.DB;
import design.ClientRegisterPanel;

public class ClientRegister extends ClientRegisterPanel {

	private static final long serialVersionUID = 1L;
	public static void Register() {
		
		String code = ClientRegisterPanel.insertClientCode.getText();
		String document = ClientRegisterPanel.insertDocNumber.getText();
		String name = ClientRegisterPanel.insertName.getText();
		String adress = ClientRegisterPanel.insertPosition.getText();
		String number = ClientRegisterPanel.insertNumber.getText();
		String complement = ClientRegisterPanel.insertCoplement.getText();
		String phone = ClientRegisterPanel.insertPhoneNumber.getText();
		String mail = ClientRegisterPanel.mail.getText();
		
		Integer cod = Integer.parseInt(code);
		Integer num = Integer.parseInt(number);
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
		    conn = DB.getConnection();
		    st = conn.prepareStatement(
				    "INSERT INTO client " 
				    + "(code, doc, name, adress, number, complement, phone, mail)"
				    + "VALUES"
				    + "(?, ?, ? ,? , ?, ?, ?, ?)");
		    
		    st.setInt(1, cod);
		    st.setString(2, document);
		    st.setString(3, name);
		    st.setString(4, adress);
		    st.setInt(5, num);
		    st.setString(6, complement);
		    st.setString(7, phone);
		    st.setString(8, mail);
		    
		    st.executeUpdate();
		    JOptionPane.showMessageDialog(null, "Cliente cadastrado com SUSSE�O!!!");
	    }
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DB.closeStatement(st);
			//DB.closeConnetction();
		}
	}
	
	public static void Search() {
		
		String name = ClientRegisterPanel.insertName.getText();
		DefaultTableModel table = (DefaultTableModel) ClientRegisterPanel.table.getModel();
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
		    ResultSet rs = st.executeQuery(
		    		"SELECT * FROM client WHERE name LIKE '" + "%" + name + "%" + "';"
		    		);
		    while(rs.next()) {
		    	
		    	table.addRow(new Object[] {
		    		rs.getInt(1), rs.getString(3), rs.getString(2), rs.getString(4) + ", " + rs.getInt(5), rs.getString(7)
		    	});
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
}
