package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import database.DB;
import design.LoginPanel;

import accessinterface.UserInterface;

public class UserLogin extends LoginPanel {
	public UserLogin() {
	}

	private static final long serialVersionUID = 1L;

	public static void GetAccess() {

		String name = LoginPanel.textField.getText();
		String password = new String(LoginPanel.passwordField.getPassword());

		if (name.equals("DEFAULT") && password.equals("admin.Cliente.CqDfPQ.S^*Gp+@tL")) {
			JOptionPane.showMessageDialog(null, "LOGIN DE ADMINISTRADOR");
			UserInterface.ManagerScreen();
		}

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from users where nickname = '" + name + "';");

			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "Ops! USUÁRIO NÃO CADASTRADO... TENTE NOVAMENTE!");
			} else {

				do {
					String checkName = rs.getString("nickname");
					String checkPassword = rs.getString("password");
					String checkPosition = rs.getString("position");

					if (!password.equals(checkPassword)) {
						JOptionPane.showMessageDialog(null, "Ops! SENHA INVÁLIDA... TENTE NOVAMENTE!");
					}

					if (password.equals(checkPassword) && checkPosition.equals("Gerente")) {
						JOptionPane.showMessageDialog(null, "SEJA BEM VINDO " + checkName + "!");
						UserInterface.ManagerScreen();
					}

					if (password.equals(checkPassword) && checkPosition.equals("Vendedor")) {
						JOptionPane.showMessageDialog(null, "SEJA BEM VINDO " + checkName + "!");
						UserInterface.SellerScreen();
					}
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			// DB.closeConnetction();
		}
	}
}
