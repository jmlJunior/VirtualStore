package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.DB;
import design.ClientRegisterPanel;

public class ClientRegister extends ClientRegisterPanel {

	private static final long serialVersionUID = 1L;
	
	public static void GenerateClientId() {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(CODE) as code FROM client");
		
			while (rs.next()) {
				int newCode = rs.getInt(1)+1;
				ClientRegisterPanel.insertClientCode.setText(String.valueOf(newCode));
				
				if (rs.getInt(1) == 0) {
					int date = LocalDate.now().getYear();
					String init = "000001";
					String clientIds = String.valueOf(date) + init;
					//Integer clientIdInt = Integer.parseInt(clientIds);
					ClientRegisterPanel.insertClientCode.setText(clientIds);
				}
			}
		}
		
		catch (SQLException e) {
		e.printStackTrace();
	    }

	    finally {
		    DB.closeStatement(st);
		    // DB.closeConnetction();
	    }
	}

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
					"INSERT INTO client " + "(code, doc, name, adress, number, complement, phone, mail)" + "VALUES"
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
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com SUSSEÇO!!!");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DB.closeStatement(st);
			// DB.closeConnetction();
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
			ResultSet rs = st.executeQuery("SELECT * FROM client WHERE name LIKE '" + "%" + name + "%" + "';");
			
			while (rs.next()) {
				table.addRow(new Object[] {rs.getInt(1), rs.getString(3), rs.getString(2),
						                   rs.getString(4) + ", " + rs.getInt(5), rs.getString(7)});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DB.closeStatement(st);
			// DB.closeConnetction();
		}
	}

	public static void Select() {

		DefaultTableModel table = (DefaultTableModel) ClientRegisterPanel.table.getModel();
		
		Connection conn = null;
		Statement st = null;

		try {
			
			int SelectedRowIndex = ClientRegisterPanel.table.getSelectedRow();
			int code = (int) table.getValueAt(SelectedRowIndex, 0);
			
			try {
				
				conn = DB.getConnection();
				st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM client WHERE code = '" + code + "';");
				
				while (rs.next()) {
					ClientRegisterPanel.insertClientCode.setText(String.valueOf(rs.getInt(1)));
					ClientRegisterPanel.insertDocNumber.setText(rs.getString(2));
					ClientRegisterPanel.insertName.setText(rs.getString(3));
					ClientRegisterPanel.insertPosition.setText(rs.getString(4));
					ClientRegisterPanel.insertNumber.setText(String.valueOf(rs.getInt(5)));
					ClientRegisterPanel.insertCoplement.setText(rs.getString(6));
					ClientRegisterPanel.insertPhoneNumber.setText(rs.getString(7));
					ClientRegisterPanel.mail.setText(rs.getString(8));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				DB.closeStatement(st);
				// DB.closeConnetction();
			}
			
		} catch (Exception e) {

		}
	}
	
	public static void ClearTable() {
		
		DefaultTableModel table = (DefaultTableModel) ClientRegisterPanel.table.getModel();
		while (table.getRowCount() > 0) {
			for (int i = 0; i < table.getRowCount(); i ++) {
			table.removeRow(i);
			}			
		}
	}
}
