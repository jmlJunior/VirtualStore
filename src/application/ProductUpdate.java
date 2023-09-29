package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import database.DB;
import database.DbIntegrityException;
import design.StockControl;

public class ProductUpdate extends StockControl {
	public ProductUpdate() {
	}

	private static final long serialVersionUID = 1L;

	public static void checkProduct() {

		Integer productCodeNumber = Integer.parseInt(StockControl.productCode.getText());
		DecimalFormat fmt = new DecimalFormat("0.00");

		Connection conn = null;
		Statement st = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT name, description, qtde, price FROM products WHERE code = '" + productCodeNumber + "';");

			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "DESCULPE!!! Produto não Cadastrado!");
			} else {

				do {

					String quantity = String.valueOf(rs.getInt(3));
					String price = fmt.format(rs.getDouble(4));

					StockControl.productName.setText(rs.getString(1));
					StockControl.productDesc.setText(rs.getString(2));
					StockControl.stockQty.setText(quantity);
					StockControl.productPrice.setText("R$ " + price);
				}

				while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DB.closeStatement(st);
			// DB.closeConnetction();
		}
	}

	public static void productDel() {

		Integer prductCodeNumber = Integer.parseInt(StockControl.productCode.getText());

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("DELETE FROM products WHERE code = ?");
			st.setInt(1, prductCodeNumber);
			st.executeUpdate();
		}

		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);
			// DB.closeConnetction();
		}

	}

	public static void productUpdate() {

		Integer productCodeNumber = Integer.parseInt(StockControl.productCode.getText());

		String productName = StockControl.actProdName.getText();
		String description = StockControl.changeProdDesc.getText();
		String qttyString = StockControl.actQtty.getText();
		String priceString = StockControl.actProdPrice.getText();

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			if (StockControl.checkNameAct.isSelected()) {
				st = conn.prepareStatement("UPDATE products " + "SET name = ? " + "WHERE " + "code = ?");
				st.setString(1, productName);
				st.setInt(2, productCodeNumber);
				st.executeUpdate();
				DB.closeStatement(st);
			}

			if (StockControl.checkDescAct.isSelected()) {
				st = conn.prepareStatement("UPDATE products " + "SET description = ? " + "WHERE " + "code = ?");
				st.setString(1, description);
				st.setInt(2, productCodeNumber);
				st.executeUpdate();
				DB.closeStatement(st);
			}

			if (StockControl.checkPriceAct.isSelected()) {
				Double price = Double.parseDouble(priceString);
				st = conn.prepareStatement("UPDATE products " + "SET price = ? " + "WHERE " + "code = ?");
				st.setDouble(1, price);
				st.setInt(2, productCodeNumber);
				st.executeUpdate();
				DB.closeStatement(st);
			}

			if (StockControl.checkStockAct.isSelected()) {
				Integer quantity = Integer.parseInt(qttyString);
				st = conn.prepareStatement("UPDATE products " + "SET qtde = ? " + "WHERE " + "code = ?");
				st.setInt(1, quantity);
				st.setInt(2, productCodeNumber);
				st.executeUpdate();
				DB.closeStatement(st);
			}
		}

		catch (SQLException f) {
			throw new DbIntegrityException(f.getMessage());
		}
	}
}
