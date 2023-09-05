package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.DB;
import design.ProductRegisterPanel;

public class ProductRegistration extends ProductRegisterPanel {
	public ProductRegistration() {
	}

	private static final long serialVersionUID = 1L;

	public static void Register() {
		
		String name = ProductRegisterPanel.insertProdName.getText();
		String code = ProductRegisterPanel.insertProdCod.getText();
		String quantity = ProductRegisterPanel.insertQtde.getText();
		String description = ProductRegisterPanel.insertProdDesc.getText();
		String price = ProductRegisterPanel.insertPrice.getText();
		Double priceValue = Double.parseDouble(price);
		Integer codeNumber = Integer.parseInt(code);
		Integer qtde = Integer.parseInt(quantity);
		
		Connection conn = null;
		PreparedStatement st = null;
		
			try {
				conn = DB.getConnection();
			    st = conn.prepareStatement(
					    "INSERT INTO products " 
					    + "(code, name, description, qtde, price)"
					    + "VALUES"
					    + "(?, ?, ? ,?, ?)");
			    st.setInt(1, codeNumber);
			    st.setString(2, name);
			    st.setString(3, description);
			    st.setInt(4, qtde);
			    st.setDouble(5, priceValue);
			    
			    st.executeUpdate();
			    JOptionPane.showMessageDialog(null, "Produto cadastrado com SUSSEÇO!!!");
		    }
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				DB.closeStatement(st);
				//DB.closeConnetction();
			}
			
			ProductRegisterPanel.insertProdName.setText("");
			ProductRegisterPanel.insertProdCod.setText("");
			ProductRegisterPanel.insertQtde.setText("");
			ProductRegisterPanel.insertProdDesc.setText("");
			ProductRegisterPanel.insertPrice.setText("");
	}
}